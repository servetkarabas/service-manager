package com.lbs.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;


/**
 * 
 * telefon kullanıcısı mı ? 
 * 
 * öyleyse phone(deviceOwner gibi birşey diyelim.
 * Hamit abi ile konuş.
 * @author Servet.Karabas
 *
 */
@Entity
public @Data	class	Kullanici{
	@Id
	int	id;
	@ManyToOne
	Role	role;	// yetki tanımı role göre belirlenecek.
	
	String	kullaniciAdi;
	String	parola;
}
