package com.lbs.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
public @Data class HasarIslem {
	
	@Id
	int	id;
	
	@ManyToOne
    @JoinColumn(name="hasar_id")
	Hasar	hasar;
	
	Date	zaman;
	
	@OneToOne
	IslemTipi islemtipi;
	
	@OneToOne
	Kullanici	kullanici;
	
	@OneToOne
	Aciklama	aciklama;
}
