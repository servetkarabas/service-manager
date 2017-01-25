package com.lbs.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Data;

/**
 * @author Servet.Karabas
 *
 Dosya Durum : PERT için Hasar Durumları
	PERT - ALTAR'DA
	PERT - HIRSIZLIK
	PERT - MAĞAZADA
		
Dosya Durum : ONARIM için Hasar Durumları
	ALTAR MAĞAZAYA KARGOLADI
	MAĞAZA MÜŞTERİYE BİLGİ VERDİ
	MAĞAZA MÜŞTERİYE TESLİM ETTİ

		
Dosya Durum : MUALLAK için Hasar Durumları
	ALTAR SERVİSE KARGOLADI
	CİHAZ MÜŞTERİDEN TESLİM ALINACAK
	HIRSIZLIK DEĞERLENDİRMEDE
	HIRSIZLIK İÇİN EVRAK BEKLENİYOR
	KULLANICI HESABI KAPATILACAK
	MAĞAZA KARGOSU ALTAR'A GELDİ
	ONARIM İÇİN ALTAR'DA BEKLİYOR
	PERT İÇİN AKSESUAR BEKLENİYOR
	PERT İÇİN IMEI KAPATILMASI BEKLENİYOR
	SERVİS ONARIMI TAMAMLADI
	SERVİS YEDEK PARÇA BEKLİYOR
	SWAP CİHAZ BEKLENİYOR
	MAĞAZA CİHAZI SERVİSE TESLİM ETTİ		
	
Dosya Durum :TEMİNAT DIŞI için Hasar Durumları
	TEMİNAT DIŞI - İADE
		
		
Dosya Durum : İHBAR için Hasar Durumları
	GİRİŞ YAPILDI
	GİRİŞ YAPILDI
	GİRİŞ YAPILDI
	CİHAZ MAĞAZADA
	MAĞAZA ALTAR'A KARGOLADI		

Dosya Durum : İADE için Hasar Durumları
	İADE - İŞLEMSİZ
	İADE - ONARIMDAN
	İADE - PERTTEN
*/

@Entity
public @Data class HasarDurum {
	@Id
	int	id;
	
/*	
  rollerin hakları ile ilgili başka bir tablo oluşturulabilir. 
  Asıl döngü dosyada 
  hasar al döngüdür
 	@ManyToOne
	@PrimaryKeyJoinColumn
	private	Role	role;
	*/
	
	private String ad;
	private String aciklama;
}
