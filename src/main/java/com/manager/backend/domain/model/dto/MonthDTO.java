package com.manager.backend.domain.model.dto;

import java.util.Set;

import com.manager.backend.domain.model.Weekly;

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
public class MonthDTO {

	private String nombreMes;

	private String anio;

	private Set<Weekly> semana;

}
