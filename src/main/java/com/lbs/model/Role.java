package com.lbs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
/*
tanımlı roller
Admin
Altar
Ms Genel Müdürlük
Ms Mağaza
Call Center
Cardif
 */


@Entity
public @Data class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name="ROLEID")
	private Long id;
	private String name;
}
