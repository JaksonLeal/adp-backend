package com.manager.backend.infraestructure.adapter.exception;

public class UserFoundException extends Exception {

	private static final long serialVersionUID = 1104478034519367432L;

	public UserFoundException() {
		super("El usuario con ese nombre ya existe en la base de datos, vuelva a intentar por favor!");
		// TODO Auto-generated constructor stub
	}

	public UserFoundException(String mensaje) {
		super(mensaje); // TODO Auto-generated constructor stub
	}

}
