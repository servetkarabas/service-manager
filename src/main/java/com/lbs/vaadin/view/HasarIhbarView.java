package com.lbs.vaadin.view;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.tepi.filtertable.FilterTable;
import org.vaadin.viritin.form.AbstractForm.SavedHandler;

import com.lbs.VaadinUI;
import com.lbs.mainView.MainScreen;
import com.lbs.model.Cihaz;
import com.lbs.model.DosyaDurum;
import com.lbs.model.Hasar;
import com.lbs.model.HasarNedeni;
import com.lbs.model.Kullanici;
import com.lbs.model.Magaza;
import com.lbs.model.Musteri;
import com.lbs.model.User;
import com.lbs.service.HasarService;
import com.lbs.vaadin.form.HasarForm;
import com.lbs.vaadin.form.ProfilePreferencesWindow;
import com.lbs.vaadin.form.UserSelect;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;
/*
 * 
 * 
 * 
 */
public class HasarIhbarView extends VerticalLayout implements View{
	private static final long serialVersionUID = -5524059458805238257L;
	public static final String VIEW_NAME = "HasarIhbar";
	private HasarService hasarService;
	private HasarForm hasarForm;
	Grid	grid;
	
	
	Hasar	hasar;	// forum Verisi için
	
	Cihaz cihaz = new Cihaz();
	Kullanici kullanici = new Kullanici();
	
	@Autowired
	HasarView hasarView;
	
	
//	private FilterTable filterTable;
	
	public HasarIhbarView() {
		initLayout();
	}

	
	// https://vaadin.com/blog/-/blogs/building-a-web-ui-for-mysql-databases-in-plain-java- 
	
	
	private void initLayout(){
		hasarForm = new HasarForm();
		hasarService = VaadinUI.get().getHasarService();

		
		removeAllComponents();
		Label	uyari = new Label("Kontrat No bilgisini nokta hariç 12 uzunluğunda 123412345678 şeklinde nümerik olarak giriniz. (Nokta girmek şart değildir.) ");
		TextField	kontratNo = new TextField("Kontrat No");
		Button hasarFormButton = new Button("Hasar Ara");
		hasarFormButton.addClickListener(click -> {
				//@todo WS den alınacak.
				hasar = new Hasar();
//				cihaz = new Cihaz();
//				kullanici = new Kullanici();
//				kullanici.setKullaniciAdi("Servet");
				cihaz.setSeriNo("A" +  (int)(Math.random()));
//				hasar.setBildirenKullanici(kullanici);
				hasar.setHasarDosyaNo("AAAAAAAAAB");
				hasar.setMusteri(new Musteri());
				hasar.getMusteri().setAd("müsteri adı");
				hasar.setCihaz(new Cihaz());
				hasar.getCihaz().setSeriNo("131231");
				hasar.setDurum(new DosyaDurum());
				hasar.getDurum().setAdi("dada");
				hasar.setMagaza(new Magaza());
				hasar.getMagaza().setAdi("magaza");
				hasar.setBildirenKullanici(new Kullanici());
				hasar.setHasarNedeni(new HasarNedeni());				
//				hasar.setCihaz(cihaz);
				
				// Hasar işlemi kaydedilecek
				// ihbar bu günün tarihi ile kaydedilecek.
				
				//VaadinUI.get().getHasarService().saveHasar(hasar);
				VaadinUI.get().setHasar(hasar);
				MainScreen.getNavigator().navigateTo(HasarView.VIEW_NAME);
			});
		addComponents(uyari, kontratNo,hasarFormButton);
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		if(event.getParameters().length()>0 && event.getParameters().contains("custom")){
			removeAllComponents();
//			MTable<CustomJobModel> jobTable = new MTable<CustomJobModel>(CustomJobModel.class)
//					.withProperties("jobName","description","teamname")
//					.setBeans(hasarService.findCustomJobModels());
//			jobTable.setWidth("100%");
//			addComponent(jobTable);
		}
		else{
			removeAllComponents();
			initLayout();
		}
	}
	
	
	
}
