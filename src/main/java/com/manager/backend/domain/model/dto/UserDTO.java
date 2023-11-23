package com.manager.backend.domain.model.dto;

import java.util.Set;

import com.manager.backend.domain.model.Workday;

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
public class UserDTO {

	private Long cedula;

	private String nombre;

	private boolean activo;

	private String edad;

	private String numCelular;

	private Set<Workday> jornada;
}
