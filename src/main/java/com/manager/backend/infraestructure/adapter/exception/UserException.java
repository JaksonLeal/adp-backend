package com.manager.backend.infraestructure.adapter.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserException extends Exception {

	private static final long serialVersionUID = 1104478034519367432L;

	private HttpStatus errorCode;
	
	private String errorMessage;

}
