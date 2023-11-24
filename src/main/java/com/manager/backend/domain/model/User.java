package com.manager.backend.domain.model;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	private Long cedula;

	private String nombre;

	private String email;

	private String password;

	private String edad;

	private String numCelular;

	private String role;

	private Boolean status;

	private Set<Workday> jornada;

}
