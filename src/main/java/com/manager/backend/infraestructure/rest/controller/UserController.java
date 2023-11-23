package com.manager.backend.infraestructure.rest.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manager.backend.application.usecases.UserCases;
import com.manager.backend.infraestructure.adapter.entity.UserEntity;
import com.manager.backend.infraestructure.adapter.exception.UserNotFoundException;

@RestController
@RequestMapping(path = "/user")
public class UserController {

	@Autowired
	private UserCases userCases;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@PostMapping("/signup")
	public ResponseEntity<String> registrarUsuario(@RequestBody UserEntity user) {
		System.out.println("entro a controlador /signup");
		try {
			System.out.println(user);
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			return userCases.singUp(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>(new UserNotFoundException("controller singup").getMessage(),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Map<String, String> requestMap) {
		try {
			return userCases.login(requestMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>(new UserNotFoundException().getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
