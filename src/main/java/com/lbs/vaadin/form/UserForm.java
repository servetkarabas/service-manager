package com.lbs.vaadin.form;

import java.util.Collection;
import java.util.List;

import org.vaadin.viritin.form.AbstractForm;
import org.vaadin.viritin.layouts.MVerticalLayout;

import com.lbs.VaadinUI;
import com.lbs.model.Magaza;
import com.lbs.model.Role;
import com.lbs.model.User;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComboBox;

public class UserForm extends AbstractForm<User>{
	private static final long serialVersionUID = 1L;
	private TextField adi = new TextField("Adı");
	private TextField soyadi = new TextField("Soyadı");
	private	PasswordField	parola = new PasswordField("Parola");
	private	PasswordField	parolaTekrar = new PasswordField("Parola Tekrarı");
//	private RoleSelect role = new RoleSelect("Role");
	
	List<Role> roles = VaadinUI.get().getRoleService().findAll();
	private ComboBox	kullaniciTur = new ComboBox("Kullanıcılar",roles);

	private List<Magaza> magazas = VaadinUI.get().getMagazaService().findAll();
	private	ComboBox	magaza = new ComboBox("Çalıştığı Mağaza",magazas);
	
	public UserForm() {
		
	}
	
	@Override
	protected Component createContent() {
		return new MVerticalLayout
				(new FormLayout
						(adi,soyadi,parola,parolaTekrar,kullaniciTur,magaza,createButtonLayout()));
	}
	
	private HorizontalLayout createButtonLayout(){
		HorizontalLayout horizontalLayout = new HorizontalLayout();
		Button saveButon = new Button("Save");
		saveButon.addClickListener(new Button.ClickListener() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {

				save(event);
			}
		});
		horizontalLayout.addComponent(saveButon);
		return horizontalLayout;
	}
	
	

}
