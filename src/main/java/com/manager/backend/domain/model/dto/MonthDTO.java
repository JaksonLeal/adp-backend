package com.manager.backend.domain.model.dto;

import java.util.Set;

import com.manager.backend.domain.model.Week;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MonthDTO {

	private String nombreMes;

	private String anio;

	private Set<Week> semana;

}
