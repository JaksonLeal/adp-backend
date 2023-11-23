package com.manager.backend.infraestructure.adapter.entity;

import java.util.Set;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@DynamicInsert
@DynamicUpdate
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
