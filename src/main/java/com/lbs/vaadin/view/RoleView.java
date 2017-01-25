package com.lbs.vaadin.view;

import org.vaadin.viritin.fields.MTable;
import org.vaadin.viritin.fields.MValueChangeEvent;
import org.vaadin.viritin.fields.MValueChangeListener;
import org.vaadin.viritin.form.AbstractForm.SavedHandler;

import com.lbs.VaadinUI;
import com.lbs.model.Role;
import com.lbs.service.RoleService;
import com.lbs.vaadin.form.RoleForm;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

public class RoleView extends VerticalLayout implements View{
	private static final long serialVersionUID = 568864087083558471L;
	public static final String VIEW_NAME = "Rol";
	private RoleService roleService;
	private RoleForm roleForm;
	public RoleView() {
	
		
		initLayout();
	}
	
	private void initLayout(){
		roleForm = new RoleForm();
		roleService = VaadinUI.get().getRoleService();
		removeAllComponents();
		
		
		// test label
//		Label label = new Label("Team View works");
//		addComponent(label);
		
		Button yeniGrupButton = new Button("Yeni Rol");
		yeniGrupButton.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				roleForm.setEntity(new Role());
				roleForm.openInModalPopup();
			}
		});
		
		
		
		addComponent(yeniGrupButton);
		
		MTable<Role> teamTable = new MTable<Role>(Role.class).
				withProperties("name");
		teamTable.setWidth("100%");
		addComponent(teamTable);
		teamTable.setBeans(roleService.findAll());
		
		roleForm.setSavedHandler(new SavedHandler<Role>() {
			private static final long serialVersionUID = 1L;

			@Override
			public void onSave(Role entity) {
				roleService.saveRole(entity);
				teamTable.setBeans(roleService.findAll());
				roleForm.getPopup().close();
			}
		});
		
		teamTable.addMValueChangeListener(new MValueChangeListener<Role>() {
			
			@Override
			public void valueChange(MValueChangeEvent<Role> event) {
				roleForm.setEntity(event.getValue());
				roleForm.openInModalPopup();
			}
		});
		
		// sağ click
//		teamTable.addActionHandler(actionHandler);
		
	}
	
	
	@Override
	public void enter(ViewChangeEvent event) {
		initLayout();
	}

}
