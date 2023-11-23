package com.manager.backend.domain.model.dto;



import com.manager.backend.domain.model.Day;
import com.manager.backend.domain.model.User;

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
public class WorkdayDTO {

	private boolean descanso;

	private int horaEntrada;

	private int horaSalida;

	private Day dia;

	private User usuario;
	
}
