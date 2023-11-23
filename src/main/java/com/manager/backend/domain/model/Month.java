package com.manager.backend.domain.model;

import java.util.LinkedHashSet;
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
public class Month {

	private Long ID;

	private String nombreMes;

	private String anio;

	private Set<Weekly> semana = new LinkedHashSet<Weekly>();

}
