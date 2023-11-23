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
public class Day {

	private Long ID;

	private String nombreDia;

	private Set<Workday> jornada;

	private Weekly semana;

}
