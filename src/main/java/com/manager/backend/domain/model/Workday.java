package com.manager.backend.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Workday {

	private Long ID;

	private boolean descanso;

	private int horaEntrada;

	private int horaSalida;

	private Day dia;

	private User usuario;

}
