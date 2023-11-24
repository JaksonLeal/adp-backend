package com.manager.backend.infraestructure.adapter.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")
public class UserEntity {

	@Id
	private Long cedula;

	private String nombre;

	private String email;

	private String password;

	private String edad;

	private String numCelular;

	private String role;

	private Boolean status;

	@JsonIgnore
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private Set<WorkdayEntity> jornada;

}
