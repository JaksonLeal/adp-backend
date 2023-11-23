package com.manager.backend.domain.model;

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
public class Workday {

	private Long ID;

	private boolean descanso;

	private int horaEntrada;

	private int horaSalida;

	private Day dia;

	private User usuario;

}
