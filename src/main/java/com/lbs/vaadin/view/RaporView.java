package com.lbs.vaadin.view;

import java.util.Arrays;
import java.util.List;

import com.lbs.VaadinUI;
import com.lbs.mainView.MainScreen;
import com.lbs.model.Magaza;
import com.vaadin.event.ShortcutAction;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.DateField;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class RaporView extends CssLayout implements View {

	public static final String VIEW_NAME = "Report";

//	private	TextField	hasarNo = new TextField("Hasar Dosya No");
//	private	TextField	kontratNo = new TextField("kontrat No");
//	private	TextField	musteriAdi	= new TextField("Müşteri Adı");
//	private	TextField	musteriSoyadi = new TextField("Müşteri Soyadı");
//	private	TextField	seriNo = new TextField("Seri No");
	
	
	private	DateField	islemTarihiIlk = new DateField(); 
	private	DateField	islemTarihiSon = new DateField();
	
	List<Magaza>	magazas = VaadinUI.get().getMagazaService().findAll();
	private	ComboBox	magaza = new ComboBox("Mağaza", magazas);
	
	List<String> durumList = Arrays.asList("Pert","Onarım","Muallak","Teminat Dışı");
	private	ComboBox	cihazDurum = new ComboBox("PertOnarım", durumList);
	
	List<String> hasarIhbarList = Arrays.asList("Hasar","İhbar");
	private	ComboBox	hasarIhbarurum = new ComboBox("Hasar ihbar", hasarIhbarList);

	

	public RaporView() {
		initLayout();
		addComponent(createContent());
	}
	private Component createContent() {
		HorizontalLayout	tarihAraligi = new HorizontalLayout(islemTarihiIlk,islemTarihiSon);
		HorizontalLayout	dosyaHL = new HorizontalLayout(cihazDurum,hasarIhbarurum);
		VerticalLayout layout = new VerticalLayout(tarihAraligi,dosyaHL,magaza,createButtonLayout());
        layout.setSpacing(true);
        layout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
		return layout;
	}
	
	private Component createButtonLayout() {
		
		Button excel = new Button("excel"); 
		Button list = new Button("List"); 
		
		list.addClickListener(click->{
			MainScreen.getNavigator().navigateTo(HasarListView.VIEW_NAME);
		});
		
		list.setClickShortcut(ShortcutAction.KeyCode.ENTER);
		return new HorizontalLayout(list,excel);
	}
	
	private void initLayout() {
		removeAllComponents();
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
	}

}
