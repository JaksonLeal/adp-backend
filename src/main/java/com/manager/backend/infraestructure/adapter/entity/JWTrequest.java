package com.manager.backend.infraestructure.adapter.entity;

public class JWTrequest {

	private String email;
	private String password;

	public JWTrequest() {

	}

	public JWTrequest(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getUsername() {
		return email;
	}

	public void setUsername(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
