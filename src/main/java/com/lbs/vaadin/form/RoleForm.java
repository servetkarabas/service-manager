package com.lbs.vaadin.form;

import org.vaadin.viritin.form.AbstractForm;
import org.vaadin.viritin.layouts.MFormLayout;
import org.vaadin.viritin.layouts.MVerticalLayout;

import com.lbs.model.Role;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Button.ClickEvent;

public class RoleForm extends AbstractForm<Role>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TextField rolename = new TextField("role name");
	public RoleForm() {
	}
	
	@Override
	protected Component createContent() {
		return new MVerticalLayout(new MFormLayout(rolename,createButtonLayout()));
	}
	
	private HorizontalLayout createButtonLayout(){
		HorizontalLayout horizontalLayout = new HorizontalLayout();
		Button saveButton = new Button("Save");
		saveButton.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 1L;
			@Override
			public void buttonClick(ClickEvent event) {
				save(event);
			}
		});
		horizontalLayout.addComponent(saveButton);
		return horizontalLayout;
	}
}
