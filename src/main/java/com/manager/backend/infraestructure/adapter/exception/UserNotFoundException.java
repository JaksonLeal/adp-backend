package com.manager.backend.infraestructure.adapter.exception;

public class UserNotFoundException extends Exception{

	private static final long serialVersionUID = 8758770844814169061L;

	public UserNotFoundException() {
		super("El usuario con ese nombre no existe en la base de datos, vuelva a intentar por favor!");
		// TODO Auto-generated constructor stub
	}

	public UserNotFoundException(String mensaje) {
		super(mensaje); // TODO Auto-generated constructor stub
	}
	
}
