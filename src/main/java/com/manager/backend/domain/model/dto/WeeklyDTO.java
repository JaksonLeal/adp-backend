package com.manager.backend.domain.model.dto;

import java.sql.Date;
import java.util.Set;

import com.manager.backend.domain.model.Day;
import com.manager.backend.domain.model.Month;

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
public class WeeklyDTO {

	private Date fecha;

	private Set<Day> dia;

	private Month mes;
}
