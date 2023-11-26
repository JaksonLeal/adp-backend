package com.manager.backend.domain.model;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Day {

	private Long ID;

	private String nombreDia;

	private Set<Workday> jornada;

	private Week semana;

}
