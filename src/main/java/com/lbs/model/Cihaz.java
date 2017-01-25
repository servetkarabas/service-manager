package com.lbs.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
public @Data class Cihaz {
	@Id
	int	id;
	
	private String 	kontratNo;	
	private String	turu;
	private String	marka;
	private String	model;	// (Tipi)
	private String	seriNo;
	private String	urunNo;
	private String	faturaTutar;
	private String	faturaTarihi;
	private String	faturaNo;
	private String	gtipi;//G+Tipi (1-2-4 yıllık gibi açıklama gelecek.)
	private String	fiyatAraligi;
}
