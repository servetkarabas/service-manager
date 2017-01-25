package com.lbs.vaadin.form;

import org.vaadin.viritin.fields.TypedSelect;

import com.lbs.VaadinUI;
import com.lbs.model.Role;
import com.vaadin.data.Property;
import com.vaadin.ui.ComboBox;

public class RoleSelect extends TypedSelect<Role> {

	
	public RoleSelect(String caption) {
		super(Role.class);
		withSelectType(ComboBox.class);
		setCaption(caption);
	}
	
	@Override
	public void setPropertyDataSource(Property newDataSource) {
		setOptions(VaadinUI.get().getTeamService().findAll());
		super.setPropertyDataSource(newDataSource);
	}
	
	
	
	
}
