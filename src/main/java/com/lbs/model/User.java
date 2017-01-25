package com.lbs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Entity
public @Data class User {
	@Id
	@GeneratedValue
	private Long id;
	String kullaniciAdi;
	String parola;
	
	@OneToOne
	@PrimaryKeyJoinColumn	
	Role role;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	Magaza	magaza;

//	int kullaniciTur;
//	String pin;

	String adi;
	String soyadi;
	
}
