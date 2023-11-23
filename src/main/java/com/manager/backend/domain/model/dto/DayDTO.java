package com.manager.backend.domain.model.dto;

import java.util.Set;

import com.manager.backend.domain.model.Weekly;
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
public class DayDTO {
	
	private String nombreDia;

	private Set<Workday> jornada;

	private Weekly semana;

}
