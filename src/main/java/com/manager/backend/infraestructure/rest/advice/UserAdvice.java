package com.manager.backend.infraestructure.rest.advice;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.manager.backend.infraestructure.adapter.exception.UserException;

@RestControllerAdvice
public class UserAdvice {

	private UserAdvice() {

	}

	@ExceptionHandler(UserException.class)
	public static ResponseEntity<Map> getUserException(UserException userException, WebRequest request) {

		Map error = new HashMap();
		error.put("satuscode", userException.getErrorCode().value());
		error.put("timestap", LocalTime.now());
		error.put("message", userException.getMessage());
		error.put("timestap", request.getDescription(false));

		return new ResponseEntity<Map>(error, userException.getErrorCode());
	}

}
