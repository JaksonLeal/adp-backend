package com.manager.backend.domain.model;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
