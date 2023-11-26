package com.manager.backend.domain.model.dto;

import java.util.Set;

import com.manager.backend.domain.model.Week;
import com.manager.backend.domain.model.Workday;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DayDTO {
	
	private String nombreDia;

	private Set<Workday> jornada;

	private Week semana;

}
