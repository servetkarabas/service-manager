package com.lbs.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Data;
// yaşam çevrimi çizilecek

/**
 * @author Servet.Karabas
 * 
 * Burada dosyanın durumu tutulacak.
 * her bir durumun altında alt durum olacak. bunlarda hasar durumda tutulacak.
 * 
 * Dosya Durum = Durum 
 * PERT	
 * ONARIM	
 * MUALLAK	
 * TEMİNAT DIŞI		
 * İHBAR		
 * İADE	
 * 
 *
 */

@Entity
public class DosyaDurum {
	@Id
	Integer	id;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private HasarDurum hasarDurum;	// Alt durum olarak değerlendir

	int	onculId;		// @todo : string yapıp ; ile ayırmak anlamlı. yoksa çift satır oluyor. 1;2
	
	String	adi;
	String	Aciklama;	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public HasarDurum getHasarDurum() {
		return hasarDurum;
	}

	public void setHasarDurum(HasarDurum hasarDurum) {
		this.hasarDurum = hasarDurum;
	}

	public int getOnculId() {
		return onculId;
	}

	public void setOnculId(int onculId) {
		this.onculId = onculId;
	}

	public String getAdi() {
		return adi;
	}

	public void setAdi(String adi) {
		this.adi = adi;
	}

	public String getAciklama() {
		return Aciklama;
	}

	public void setAciklama(String aciklama) {
		Aciklama = aciklama;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
}
