package com.manager.backend.infraestructure.adapter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.WebRequest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserException extends Exception {

	private static final long serialVersionUID = 1104478034519367432L;

	private HttpStatus errorCode;

	public UserException(String errorMessage, HttpStatus errorCode) {
		super(errorMessage);
		this.errorCode = errorCode;
	}

}
