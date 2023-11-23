package com.manager.backend.infraestructure.adapter.entity;

import java.sql.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "semana")
public class WeeklyEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;

	private Date fecha;

	@OneToMany(mappedBy = "semana", cascade = CascadeType.ALL)
	private Set<DayEntity> dia;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	private MonthEntity mes;

}
