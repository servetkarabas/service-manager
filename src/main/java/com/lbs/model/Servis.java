package com.lbs.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

// Firma
@Entity
public @Data	class Servis {
	@Id
	int	id;
	
	String	adi;
	String	konumu;
}
