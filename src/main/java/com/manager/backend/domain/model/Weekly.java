package com.manager.backend.domain.model;

import java.sql.Date;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Weekly {

	private Long ID;

	private Date fecha;

	private Set<Day> dia;

	private Month mes;

}
