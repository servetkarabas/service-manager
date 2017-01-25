package com.lbs.vaadin.view;

import java.util.List;

import org.tepi.filtertable.FilterTable;
import org.vaadin.viritin.form.AbstractForm.SavedHandler;

import com.lbs.VaadinUI;
import com.lbs.model.Hasar;
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
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;

public class HasarListView extends VerticalLayout implements View{
	private static final long serialVersionUID = -5524059458805238257L;
	public static final String VIEW_NAME = "HasarList";
	private HasarService hasarService;
	private HasarForm hasarForm;
	Grid	grid;
	
	Hasar	hasar;	// forum Verisi için
//	private FilterTable filterTable;
	
	public HasarListView() {
		initLayout();
	}

	
	// https://vaadin.com/blog/-/blogs/building-a-web-ui-for-mysql-databases-in-plain-java- 
	
	
	private void initLayout(){
		hasar = VaadinUI.get().getHasar();
		hasarForm = new HasarForm();
		hasarService = VaadinUI.get().getHasarService();

		
		removeAllComponents();

		Button hasarFormButton = new Button("Hasar Formu");
		Button yeniFormButton = new Button("Yeni Form");
		
		yeniFormButton.addClickListener(click->{
			ProfilePreferencesWindow.open(new User(), false);
		});
		
		hasarFormButton.addClickListener(click -> {
				//@todo new hasar yerine seçili kaydı gösterecek.
				hasarForm.setEntity(new Hasar());
				hasarForm.openInModalPopup();
			});
		addComponent(hasarFormButton);
		addComponent(yeniFormButton);

		hasarForm.setSavedHandler(new SavedHandler<Hasar>() {
			@Override
			public void onSave(Hasar entity) {
				hasarService.saveHasar(entity);
				hasarForm.getPopup().close();
			}
		});
		
		List<Hasar> hasarList = hasarService.findAll();
		
		final BeanItemContainer<Hasar> ds = 
			    new BeanItemContainer<Hasar>(Hasar.class, hasarList);
		grid = new Grid("Hasar Kayıt Listesi",ds);
		grid.addSelectionListener(e->updateForm());
		addComponent(grid);
		grid.setSizeFull();
		setExpandRatio(grid, 1);
		//filterTable
//		filterTable = new FilterTable();
//		filterTable.addContainerProperty("hasarno",String.class, null);
//		filterTable.addContainerProperty("hasarDosyaNo", Label.class, null);
//		filterTable.addContainerProperty("servisRaporu", Button.class, null);
//		filterTable.addContainerProperty("ad", String.class, null);
//		filterTable.addContainerProperty("soyad", Button.class, null);
//		filterTable.addContainerProperty("hasarNedeniAciklama", Button.class, null);
//		filterTable.setWidth("100%");



		fillTable();
	}


	private void updateForm() {
		if(grid.getSelectedRows().isEmpty()){
			setFormVisible(false); // ??
		}else{
			hasar = (Hasar) grid.getSelectedRow();
			BeanFieldGroup.bindFieldsUnbuffered(hasar, hasarForm);
			setFormVisible(true);
		}
	}


	private void setFormVisible(boolean b) {
		
	}


	@SuppressWarnings("unchecked")
	private void fillTable(){
//		grid.removeAllItems();

		
//		for(Hasar hasar : hasarService.findAll()){
//			Object id = filterTable.addItem();
//			filterTable.getContainerProperty(id, "hasarno").setValue(hasar.getHasarno());
//			Label label = new Label(hasar.getHasarDosyaNo());
//			filterTable.getContainerProperty(id, "hasarDosyaNo").setValue(label);
//			
//			Button	button = new Button(hasar.getMagaza().getMagazaAdi());
//			button.setStyleName(ValoTheme.BUTTON_FRIENDLY);
//			filterTable.getContainerProperty(id, "tazminTipi").setValue(button);
//
//			button.addClickListener(new Button.ClickListener() {
//				private static final long serialVersionUID = 1L;
//
//				@Override
//				public void buttonClick(ClickEvent event) {
//
//					Window window = new Window("Firma Bilgisi");
//					window.setModal(true);
//					window.center();
//					VerticalLayout verticalLayout = new VerticalLayout();
//
//					verticalLayout.setSpacing(true);
//					verticalLayout.setMargin(true);
//					UserSelect userSelect = new UserSelect("Change User");
//					userSelect.setBeans(VaadinUI.get().getUserService().findAll());
//					verticalLayout.addComponent(userSelect);
//
//					Button changeUser = new Button("Change User");
//					changeUser.addClickListener(new Button.ClickListener() {
//
//						@Override
//						public void buttonClick(ClickEvent event) {
//
//							if(userSelect.getValue()!=null){
////								hasar.setUser(userSelect.getValue());
////								VaadinUI.get().getJobService().saveJob(hasar);
//								fillTable();
//								window.close();
//							}
//						}
//					});
//					verticalLayout.addComponent(changeUser);
//					window.setContent(verticalLayout);
//					VaadinUI.get().addWindow(window);
//				}
//			});

//			filterTable.getContainerProperty(id, "user").setValue(userInfoButton);
//			filterTable.getContainerProperty(id, "team").setValue(hasar.getUser().getTeam().getTeamname());
//			Button viewButton = new Button("User Info View");
//			viewButton.addClickListener(new Button.ClickListener() {
//				@Override
//				public void buttonClick(ClickEvent event) {
//					VaadinUI.get().getNavigator().navigateTo("user/"+hasar.getUser().getId());
//				}
//			});
//			viewButton.setStyleName(ValoTheme.BUTTON_LINK);
//			filterTable.getContainerProperty(id, "userView").setValue(viewButton);
//		}
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
