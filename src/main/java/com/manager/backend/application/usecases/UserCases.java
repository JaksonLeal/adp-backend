package com.manager.backend.application.usecases;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.manager.backend.infraestructure.adapter.entity.UserEntity;

public interface UserCases {

	ResponseEntity<?> singUp(UserEntity user);

	ResponseEntity<?> login(Map<String, String> requestMap);

}
