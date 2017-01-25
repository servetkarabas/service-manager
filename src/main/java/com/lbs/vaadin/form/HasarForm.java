package com.lbs.vaadin.form;
import java.util.List;

import org.vaadin.viritin.form.AbstractForm;
import org.vaadin.viritin.layouts.MFormLayout;
import org.vaadin.viritin.layouts.MVerticalLayout;

import com.lbs.VaadinUI;
import com.lbs.model.DosyaDurum;
import com.lbs.model.Hasar;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.DateField;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;

public class HasarForm extends	AbstractForm<Hasar>{
	private static final long serialVersionUID = 1L;
	private	Label	id = new Label("id");
	List<DosyaDurum>	durums = VaadinUI.get().getDurumService().findAll();
	private	ComboBox	durum = new ComboBox("Durum",durums);
	private TextField	hasarDosyaNo = new TextField("Hasar Dosya No");	// () : kod : Date+decimal(3)
	private TextField	musteri = new TextField("Müşteri");		// Musteri kullanıcı dan farkı ne???? 
	private TextField	cihaz = new TextField("Cihaz");				// Cihaz
	private DateField	hasarTarihi = new DateField();
	private DateField	ihbarTarihi = new DateField();
	private TextField	hasarNedeni = new TextField("Hasar Nedeni");//HasarNedeni hasarNedeni;
	private	TextField	tazminTipi = new TextField("Tazmin Tipi");	//boolean tazminTipi;// (E/H pert ya da tamir-onarım anlamında)
	private	TextField	magaza	= new TextField("Mağaza");//private Magaza magaza; //  (kaydın yapıldığı/tesli edilecek mağaza)
	private TextField	bildirenKullanici = new TextField("Bildiren Kullanıcı");//Kullanici bildirenKullanici; // (işlem kayıtlarında olacak)
	private TextArea 	servisRaporu = new TextArea("Servis Raporu"); 
	private TextField	onarimTutari = new TextField("Onarım Tutarı");
	private TextField	oncekiTutar = new TextField("Önceki Tutar");
	private TextField	oncekiHasarSayisi=new TextField("Önceki Hasar Sayısı");
	private	TextField	pertTutari = new TextField("Pert Tutarı");;
	private	TextField	retNedeni = new TextField("Ret Nedeni");
	private	TextField	durumId = new TextField("Durum");

	@Override
	protected Component createContent() {
		return new MVerticalLayout(new MFormLayout(id,durum,hasarDosyaNo,musteri,cihaz,hasarTarihi,ihbarTarihi,
				hasarNedeni,tazminTipi,magaza,bildirenKullanici,servisRaporu,onarimTutari,oncekiTutar,oncekiHasarSayisi,
				pertTutari,retNedeni,durumId,
				createButtonLayout()));
	}
	
	/**
	 * Button Layout
	 * @return
	 */
	private Component createButtonLayout() {
		HorizontalLayout	horizontalLayout = new HorizontalLayout();
		Button	saveButton = new Button("Kaydet");
		saveButton.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void buttonClick(ClickEvent event) {
				save(event);
			}
		});
		horizontalLayout.addComponent(saveButton);
		return	horizontalLayout;
	}
}