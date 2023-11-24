package com.manager.backend.domain.model;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Month {

	private Long ID;

	private String nombreMes;

	private String anio;

	private Set<Weekly> semana;

}
