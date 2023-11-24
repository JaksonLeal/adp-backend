package com.manager.backend.domain.model.dto;

import java.util.Set;

import com.manager.backend.domain.model.Workday;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

	private Long cedula;

	private String nombre;

	private String email;

	private String edad;

	private String numCelular;

	private String role;

	private Boolean status;

	private Set<Workday> jornada;
	
}
