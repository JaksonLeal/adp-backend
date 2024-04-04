package com.manager.backend.infraestructure.rest.controller;

import java.security.Principal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manager.backend.application.service.UserDetailService;
import com.manager.backend.application.usecases.UserCases;
import com.manager.backend.infraestructure.adapter.entity.UserEntity;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserCases userCases;

	@Autowired
	private UserDetailService userDetailService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@PostMapping("/signup")
	public ResponseEntity<String> registrarUsuario(@RequestBody UserEntity user) {
		System.out.println("entro a controlador /signup " + user);
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return userCases.singUp(user);
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Map<String, String> requestMap) {
		System.out.println("entro a controlador /login " + requestMap);
		return userCases.login(requestMap);
	}

	@GetMapping("/actual-usuario")
	public User obtenerUsuarioActual(Principal principal) {
		System.out.println(principal);
		System.out.println("jaklol"+this.userDetailService.loadUserByUsername(principal.getName()));
		return (User) this.userDetailService.loadUserByUsername(principal.getName());
	}
}
