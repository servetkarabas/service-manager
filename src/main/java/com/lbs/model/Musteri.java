package com.lbs.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

// cari kart

@Entity
public @Data	class Musteri {
	@Id
	int	id;
	String	ad;
	String	soyad;
	String	telNo;
	String	adres;
	String	tcno;
	String	vergiDairesi;
	String	vergiNumarasi;
}
