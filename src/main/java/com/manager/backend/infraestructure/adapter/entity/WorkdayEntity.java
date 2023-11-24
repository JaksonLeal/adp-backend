package com.manager.backend.infraestructure.adapter.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "jornada")
public class WorkdayEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;

	private boolean descanso;

	private int horaEntrada;

	private int horaSalida;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	private DayEntity dia;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private UserEntity usuario;

}
