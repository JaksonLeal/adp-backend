package com.manager.backend.domain.model.dto;



import com.manager.backend.domain.model.Day;
import com.manager.backend.domain.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkdayDTO {

	private boolean descanso;

	private int horaEntrada;

	private int horaSalida;

	private Day dia;

	private User usuario;
	
}
