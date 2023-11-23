package com.manager.backend.domain.model;

import java.sql.Date;
import java.util.Set;

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
public class Weekly {

	private Long ID;

	private Date fecha;

	private Set<Day> dia;

	private Month mes;

}
