package com.lbs.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
public @Data	class HasarNedeni {
	@Id
	int	id;
	int	onTanimliNeden;	// gerçek hasar nedeni. 			// @todo : düşme, düşürülme gibi . enumeration bir tanım olmalı
	String	beyan;	// Call center tarafından girilen
	//String	aciklama;
}
