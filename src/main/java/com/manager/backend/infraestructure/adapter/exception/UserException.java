package com.manager.backend.infraestructure.adapter.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserException {

	private int statusCode;
	private String errorMessage;
	private LocalDateTime timestamp;

	public UserException(String errorMessage, HttpStatus errorCode) {

		this.statusCode = errorCode.value();
		this.timestamp = LocalDateTime.now();
		this.errorMessage = errorMessage;

	}

}
