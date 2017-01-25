package com.lbs.vaadin.view;

import java.util.Arrays;
import java.util.List;

import org.vaadin.viritin.layouts.MFormLayout;
import org.vaadin.viritin.layouts.MVerticalLayout;

import com.lbs.VaadinUI;
import com.lbs.mainView.MainScreen;
import com.lbs.model.Magaza;
import com.lbs.search.SearchLogic;
import com.vaadin.event.ShortcutAction;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Calendar;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.DateField;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Link;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

/**
 * A view for performing create-read-update-delete operations on products.
 *
 * See also {@link SearchLogic} for fetching the data, the actual CRUD
 * operations and controlling the view based on events from outside.
 */
public class SearchView extends CssLayout implements View {
	
	public static final String VIEW_NAME = "Search";


	
	private	TextField	hasarNo = new TextField("Hasar Dosya No");
	private	TextField	kontratNo = new TextField("kontrat No");
	private	TextField	musteriAdi	= new TextField("Müşteri Adı");
	private	TextField	musteriSoyadi = new TextField("Müşteri Soyadı");
	private	TextField	seriNo = new TextField("Seri No");
//	private	DateField	bildirimTarihiIlk = new DateField(); 
//	private	DateField	bildirimTarihiSon = new DateField();

	List<Magaza>	magazas = VaadinUI.get().getMagazaService().findAll();
	private	ComboBox	magaza = new ComboBox("Mağaza", magazas);
	
	List<String> pertOnarimList = Arrays.asList("Pert","Onarım");
	private	ComboBox	pertOnarim = new ComboBox("PertOnarım", pertOnarimList);
	private	CheckBox	arsivSecenek	= new CheckBox("Arsive Gönderilecek Dosyaları Dahil Et");

	public SearchView() {
		initLayout();
		addComponent(createContent());
	}
	private Component createContent() {
		HorizontalLayout isimSoyisim = new HorizontalLayout(musteriAdi,musteriSoyadi);
//		HorizontalLayout	tarihAraligi = new HorizontalLayout(bildirimTarihiIlk,bildirimTarihiSon);
		HorizontalLayout	dosyaHL = new HorizontalLayout(hasarNo,kontratNo);
		VerticalLayout layout = new VerticalLayout(dosyaHL,isimSoyisim,seriNo,magaza,pertOnarim,arsivSecenek,
				createButtonLayout());
		
		layout.setMargin(false);
	    layout.setSizeFull();
        layout.setSpacing(true);
        layout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
		return layout;
	}
	
	private Component createButtonLayout() {
		
		Button excel = new Button("Excel"); 
		Button list = new Button("List"); 
		Button bugun = new Button("Bugün");
		
		list.addClickListener(click->{
			MainScreen.getNavigator().navigateTo(HasarListView.VIEW_NAME);
		});
		
		list.setClickShortcut(ShortcutAction.KeyCode.ENTER);
		return new HorizontalLayout(list,excel,bugun);
	}
	
	private void initLayout() {
		removeAllComponents();
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
	}
}
