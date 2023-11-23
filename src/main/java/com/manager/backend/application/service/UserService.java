package com.manager.backend.application.service;

import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.manager.backend.application.usecases.UserCases;
import com.manager.backend.infraestructure.adapter.entity.UserEntity;
import com.manager.backend.infraestructure.adapter.exception.UserNotFoundException;
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

		try {
			if (validateSingudMap(user)) {
				UserEntity userLocal = userRepository.findByEmail(user.getEmail());
				if (Objects.isNull(userLocal)) {
					user.setStatus(false);
					user.setRole("user");
					userRepository.save(getUserFromMap(user));
					return new ResponseEntity<String>("Usuario registrado con exito", HttpStatus.CREATED);
				} else {
					return new ResponseEntity<String>(new UserNotFoundException("service singup").getMessage(),
							HttpStatus.BAD_REQUEST);

				}
			} else {
				return new ResponseEntity<String>(new UserNotFoundException("service singup").getMessage(),
						HttpStatus.BAD_REQUEST);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return new ResponseEntity<String>(new UserNotFoundException("service singup").getMessage(),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private boolean validateSingudMap(UserEntity user) {

		if (user.getCedula() != null && user.getEmail() != null && user.getNombre() != null
				&& user.getPassword() != null) {
			return true;
		} else {
			return false;
		}

	}

	private UserEntity getUserFromMap(UserEntity user) {
		user.setStatus(false);
		user.setRole("user");
		return user;
	}

	@Override
	public ResponseEntity<String> login(Map<String, String> requestMap) {
		log.info("entro a login {}", requestMap);
		try {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(requestMap.get("email"), requestMap.get("password")));
			if (authentication.isAuthenticated()) {
				if (userDetailService.getUserDetail().getStatus()) {
					return new ResponseEntity<String>(
							"{\"token\":\"" + jwtUtil.generateToken(userDetailService.getUserDetail().getEmail(),
									userDetailService.getUserDetail().getRole()) + "\"}",
							HttpStatus.OK);
				} else {
					return new ResponseEntity<String>("{\"mensaje\":\"" + "espere la aprobacion del admin" + "\"}",
							HttpStatus.BAD_REQUEST);
				}
			}
		} catch (Exception e) {
			log.error("{}", e);
		}
		return new ResponseEntity<String>("{\"mensaje\":\"" + "credenciales incorrectas" + "\"}",
				HttpStatus.BAD_REQUEST);
	}

}
