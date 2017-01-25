package com.lbs.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;

//Tablo : Hasar (Hasar_bildirim)

@Entity
@Table(name="hasar")
public @Data class Hasar {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	int	id;

	private String	hasarDosyaNo;	// () : kod : Date+decimal(3)
	private String	servisRaporu; 
	private float	onarimTutari;
	private	float	pertTutari;
	boolean 		tazminTipi;// (E/H pert ya da tamir-onarım anlamında) ???
	int				retNedeni;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private DosyaDurum durum;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Musteri musteri;		// kullanıcı dan farkı ne???? 
	
	@ManyToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Cihaz cihaz;
	
	@OneToOne
	private HasarNedeni hasarNedeni;

	@ManyToOne
	@PrimaryKeyJoinColumn
	private Magaza magaza; //  (kaydın yapıldığı/tesli edilecek mağaza)
	
	@ManyToOne
	@PrimaryKeyJoinColumn
	private Kullanici bildirenKullanici; // (işlem kayıtlarında olacak) Call center da kaydı giren kullanıcı
	
//	@ElementCollection
//    @CollectionTable(name="Aksesuar")
//	@PrimaryKeyJoinColumn
//    private  List<Aksesuar> aksesuar = new ArrayList<Aksesuar>(); //aksesuarid[] (aksesuar var ise bir dizi seçilebilir.)
//	
//	@OneToOne
//	@PrimaryKeyJoinColumn
//	Aciklama aciklama;
}