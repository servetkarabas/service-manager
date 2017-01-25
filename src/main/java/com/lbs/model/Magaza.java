package com.lbs.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

// @todo Aktarım işi için alan gerekebilir. Magazaya bağlı hasar kayıtları başka bir mağazaya aktarılabilir. Önceki uygulamada Aktarım kod tanımı yapılmış
// düşünülecek.
@Entity
public @Data	class Magaza {
	@Id
	int	id;
	String kod;
	String	adi;
	String	yetkili;
	String	telefon;
	String	email;
	String	adresi;
}
