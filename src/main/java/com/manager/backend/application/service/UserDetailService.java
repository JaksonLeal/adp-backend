package com.manager.backend.application.service;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.manager.backend.infraestructure.adapter.entity.UserEntity;
import com.manager.backend.infraestructure.adapter.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service // esta clase carga un usuario por el username
public class UserDetailService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	private UserEntity userDetail;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("entro a loadUserByUsername {}", username);

		userDetail = userRepository.findByEmail(username);

		if (!Objects.isNull(userDetail)) {
			return new User(userDetail.getEmail(), userDetail.getPassword(), new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("usuario no encontrado");
		}

	}

	public UserEntity getUserDetail() {
		return userDetail;
	}

}
