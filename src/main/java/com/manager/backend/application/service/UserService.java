package com.manager.backend.application.service;

import java.security.Principal;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.manager.backend.application.usecases.UserCases;
import com.manager.backend.domain.model.constant.UserConstant;
import com.manager.backend.infraestructure.adapter.entity.UserEntity;
import com.manager.backend.infraestructure.adapter.exception.UserException;
import com.manager.backend.infraestructure.adapter.repository.UserRepository;
import com.manager.backend.infraestructure.config.JwtUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService implements UserCases {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailService userDetailService;

	@Autowired
	private JwtUtil jwtUtil;

	@Override
	public ResponseEntity<String> singUp(UserEntity user) {
		log.info("Registro interno de un usuario{}", user);

		if (validateSingup(user)) {
			UserEntity userLocal;
			try {
				userLocal = userRepository.findByEmail(user.getEmail());
			} catch (Exception e) {
				return getException(HttpStatus.INTERNAL_SERVER_ERROR, UserConstant.DB_BAD_CONNECTION);
			}
			if (Objects.isNull(userLocal)) {
				user.setStatus(false);
				user.setRole("user");
				try {
					userRepository.save(user);
				} catch (Exception e) {
					return getException(HttpStatus.INTERNAL_SERVER_ERROR, UserConstant.DB_BAD_CONNECTION);
				}
				return getException(HttpStatus.CREATED, UserConstant.SUCCESSFUL);
			} else {
				return getException(HttpStatus.CONFLICT, String.format(UserConstant.EMAIL_CONFLICT, user.getEmail()));
			}
		} else {
			return getException(HttpStatus.BAD_REQUEST, UserConstant.INVALID_DATA);
		}

	}

	private boolean validateSingup(UserEntity user) {
		return (user.getCedula() != null && user.getEmail() != null && user.getNombre() != null
				&& user.getPassword() != null);
	}

	private ResponseEntity<String> getException(HttpStatus hs, String m) {
		return ResponseEntity.status(hs).body(new UserException(m).getMessage());
	}

	@Override
	public ResponseEntity<String> login(Map<String, String> requestMap) {
		log.info("entro a login service {}", requestMap);
		if (authenticate(requestMap)) {
			UserEntity user = userDetailService.getUserDetail();
			if (user.getStatus()) {
				String token = jwtUtil.generateToken(user.getEmail(), user.getRole());
				Principal principal=null;
				System.out.println(principal);
				return ResponseEntity.ok("{\"token\":\"" + token + "\"}");
			} else {
				return getException(HttpStatus.BAD_REQUEST,
						String.format(UserConstant.CUSTOM_V, "espere la aprobacion del admin"));
			}
		}
		return getException(HttpStatus.BAD_REQUEST,
				String.format(UserConstant.CUSTOM_K_V, "mensaje", "credenciales incorrectas"));
	}

	private boolean authenticate(Map<String, String> requestMap) {
		try {
			return authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(requestMap.get("email"), requestMap.get("password")))
					.isAuthenticated();
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}

}
