package com.lbs.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
public @Data	class IslemTipi {
	@Id
	int	id;
	
	String	adi;
}
