package com.manager.backend.domain.model.dto;

import java.sql.Date;
import java.util.Set;

import com.manager.backend.domain.model.Day;
import com.manager.backend.domain.model.Month;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeeklyDTO {

	private Date fecha;

	private Set<Day> dia;

	private Month mes;
}
