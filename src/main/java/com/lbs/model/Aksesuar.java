package com.lbs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
public @Data class Aksesuar {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	int	id;
	String	adi;
}
