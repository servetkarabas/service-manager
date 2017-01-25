package com.lbs.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Data;

@Entity
public @Data class Aciklama {
	@Id
	int	id;

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	Hasar hasar;
	
	String	cihazKozmetik; 	//(eski adı durum, Mağazanın yaptığı açıklama)
	String	hasarBeyani;	// (müşterinin söyledikleri)
}
