package com.lbs.vaadin.view;

import java.util.List;

import com.lbs.VaadinUI;
import com.lbs.model.DosyaDurum;
import com.lbs.model.Hasar;
import com.lbs.model.HasarDurum;
import com.lbs.model.HasarIslem;
import com.lbs.model.Magaza;
import com.lbs.model.Servis;
import com.lbs.service.HasarService;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.fieldgroup.PropertyId;
import com.vaadin.data.util.BeanItem;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import de.steinwedel.messagebox.MessageBox;

/*
 * Ihbar ile WS den getirilen hasarı görüntüler.
 */
public class HasarView extends VerticalLayout implements View {

	private static final long serialVersionUID = -5524059458805238257L;
	public static final String VIEW_NAME = "Hasar";
	private HasarService hasarService = VaadinUI.get().getHasarService();
	private Label id = new Label("id");

	List<DosyaDurum> durums = VaadinUI.get().getDurumService().findAll();
	List<HasarDurum> hDurums = VaadinUI.get().getHasarDurumService().findAll();
	List<Servis> serviss = VaadinUI.get().getServisService().findAll();
	List<Magaza> magazas = VaadinUI.get().getMagazaService().findAll();

	// kod :
	// Müşteri Grubu // Date+decimal(3)
//	private TextField musteri = new TextField("Müşteri"); //
	@PropertyId("musteri.ad")
	private TextField musteriAdi = new TextField("Adı"); //
	@PropertyId("musteri.soyad")
	private TextField musteriSoyadi = new TextField("Soyadı"); //
	@PropertyId("musteri.tcno")
	private TextField musteriTCKN = new TextField("TC Kimlik No"); //
	@PropertyId("musteri.telNo")
	private TextField musteriTelNo = new TextField("Tel No");
	@PropertyId("musteri.adres")
	private TextField musteriAdres = new TextField("Adres");

	// Cihaz Grubu
	//private TextField cihaz = new TextField("Cihaz"); // Cihaz
	@PropertyId("cihaz.kontratNo")
	private TextField cihazKontratNo = new TextField("Kontrat No"); //
	@PropertyId("cihaz.faturatarihi")
	private TextField cihazFaturaTarihi = new TextField("Fatura Tarihi"); //
	@PropertyId("cihaz.faturaNo")
	private TextField cihazFaturaNo = new TextField("Fatura No"); //
	@PropertyId("cihaz.faturaTutar")
	private TextField cihazFaturaTutar = new TextField("Fatura Tutar"); //
	@PropertyId("cihaz.gtip")
	private TextField cihazGarantiTipi = new TextField("Garanti Tipi"); //
	@PropertyId("cihaz.marka")
	private TextField cihazMarka = new TextField("Marka"); //
	@PropertyId("cihaz.model")
	private TextField cihazModel = new TextField("Model"); //
	@PropertyId("cihaz.serino")
	private TextField cihazSeriNo = new TextField("Seri No"); //
	@PropertyId("cihaz.turu")
	private TextField cihazTuru = new TextField("Türü"); //
	@PropertyId("cihaz.urunNo")
	private TextField cihazUrunNo = new TextField("Ürün No"); //

	
	@PropertyId("magaza.adi")
	private ComboBox satisMagaza = new ComboBox("Satış Mağazası",magazas);

	// Hasar Grubu
	@PropertyId("DosyaDurum.adi")
	private ComboBox hasarDurum = new ComboBox("Durum", durums);
	@PropertyId("Hasar.hasarDosyaNo")	
	private TextField hasarDosyaNo = new TextField("Dosya No"); // () :
	@PropertyId("HasarIslem.zaman")
	private DateField hasarTarihi = new DateField("Hasar Tarihi");
	@PropertyId("HasarIslem.zaman")
	private DateField HasarIhbarTarihi = new DateField("Ihbar Tarihi");
	@PropertyId("HasarNedeni.adi")
	private ComboBox hasarNedeni = new ComboBox("Hasar Nedeni");// HasarNedeni
	@PropertyId("HasarNedeni.beyan")																
	private TextArea hasarBeyani = new TextArea("Hasar Beyanı");// Call Center
																// tarafından
																// dooldurulacak.
																// Eski Mağaza
																// Notu
	// private CheckBoxGroup<ET> checkBoxGroupAksesuarDurumu = new
	// CheckBoxGroup<ET>();
	private CheckBox aksesuarKulaklik = new CheckBox("Kulaklık");
	private CheckBox aksesuarSarjCihazi = new CheckBox("Şarj Cihazı");
	private CheckBox aksesuarKutu = new CheckBox("Kutu");
	private HorizontalLayout	aksesuarHL = new HorizontalLayout();
	private TextArea cihazFizikiKozmetikDurum = new TextArea("Kozmetik Durum");// Mağaza
																				// tarafından
																				// doldurulacak.
	// @todo mağaza listesi eklenecek.
	private ComboBox hasarMagaza = new ComboBox("Mağaza",magazas);// private Magaza
															// magaza;(kaydın
															// yapıldığı/teslim
															// edilecek mağaza)

	// Dosya Durum Gurubu
	private ComboBox dosyaDurum = new ComboBox("Dosya Durumu",durums); // pert, onarım,
																// teminat
																// dışı,Muallak....
	
	private ComboBox cihazDurum = new ComboBox("Cihaz Durumu",hDurums);
	private ComboBox teknikServis = new ComboBox("Teknik Servis"); // @todo : excel de listesi var. oradan alınıp yazılacak.
	private TextArea servisRaporu = new TextArea("Servis Raporu");
	private TextField onarimTutari = new TextField("Onarım Tutarı");
	private TextField oncekiTutar = new TextField("Önceki Tutar");
	private TextField oncekiHasarSayisi = new TextField("Önceki Hasar Sayısı");
	private TextField pertTutari = new TextField("Pert Tutarı");
	private ComboBox retNedeni = new ComboBox("Ret Nedeni");		// @todo : hamit abi ile birlikte yapılacak.
	private TextArea retNedeniAciklama = new TextArea("Açıklama");

	private TextField bildirenKullanici = new TextField("Bildiren Kullanıcı");// Kullanici
																				// bildirenKullanici;
	final	FieldGroup	fieldGroup = new FieldGroup();
	Hasar hasar = null; // forum Verisi için
	// private FilterTable filterTable;
	
	

	public HasarView() {
		initLayout();
		initializeFormValue();
	}

	private void initializeFormValue() {
		hasar = VaadinUI.get().getHasar();
		
		if (hasar == null) {
			hasar = new Hasar();
		}
		hasarDosyaNo.setValue(hasar.getHasarDosyaNo());
		//hasarDosyaNo.setCaption(hasar.getHasarDosyaNo());
		BeanItem<Hasar> item = new BeanItem<Hasar>(hasar);

		item.addNestedProperty("cihaz.faturaTarihi");
		item.addNestedProperty("cihaz.faturaNo");
		item.addNestedProperty("cihaz.faturaTutar");
		
		fieldGroup.setItemDataSource(item);
        fieldGroup.setBuffered(false);
        fieldGroup.bindMemberFields(this);
	}

	// https://vaadin.com/blog/-/blogs/building-a-web-ui-for-mysql-databases-in-plain-java-

	private void initLayout() {
		Panel mainPanel = new Panel();
		Panel panelCihaz = new Panel();
		Panel panelMusteri = new Panel();
		Panel panelHasar = new Panel();
		Panel panelDosya = new Panel();
		// Create the content
		FormLayout contentCihaz = new FormLayout();
		panelCihaz.setCaption("Cihaz");
		contentCihaz.addComponents(cihazKontratNo,cihazFaturaTarihi, cihazFaturaNo, cihazFaturaTutar, cihazGarantiTipi,
				cihazMarka, cihazModel, cihazSeriNo, cihazTuru, cihazUrunNo, satisMagaza);
		contentCihaz.setMargin(true);
		panelCihaz.setContent(contentCihaz);

//		setWidth("100%");
//		setHeight(null);

		FormLayout contentMusteri = new FormLayout();
		panelMusteri.setCaption("Müşteri");
		contentMusteri.addComponents(musteriAdi, musteriSoyadi, musteriTCKN, musteriTelNo, musteriAdres);
		contentMusteri.setMargin(true);
		panelMusteri.setContent(contentMusteri);

		
		FormLayout contentHasar = new FormLayout();
		panelHasar.setCaption("Hasar");
		aksesuarHL.addComponents(aksesuarKulaklik,aksesuarSarjCihazi,aksesuarKutu);
		contentHasar.addComponents(hasarDurum,hasarDosyaNo,hasarTarihi,HasarIhbarTarihi,hasarNedeni,hasarBeyani,aksesuarHL,cihazFizikiKozmetikDurum,hasarMagaza);
		contentHasar.setMargin(true);
		panelHasar.setContent(contentHasar);
		
		FormLayout	contentDosya = new FormLayout();
		contentDosya.setCaption("Durum");
		contentDosya.addComponents(cihazDurum,teknikServis,servisRaporu,onarimTutari,oncekiTutar,oncekiHasarSayisi,pertTutari,retNedeni,retNedeniAciklama,bildirenKullanici);
		contentDosya.setMargin(true);
		panelDosya.setContent(contentDosya);
		
		mainPanel.setSizeFull();
		
		setSizeFull();
		FormLayout	mainPanelContent = new FormLayout();
		mainPanelContent.setMargin(true);
		HorizontalLayout	hl = createButtonLayout();
		mainPanelContent.addComponents(panelMusteri,panelCihaz, panelHasar, panelDosya,hl);
		mainPanel.setContent(mainPanelContent);
		addComponent(mainPanel);
	}

	/**
	 * Button Layout
	 * 
	 * @return
	 */
	private HorizontalLayout createButtonLayout() {
		HorizontalLayout horizontalLayout = new HorizontalLayout();
		Button saveButton = new Button("Kaydet");
		saveButton.addClickListener(click -> {
			try {
				MessageBox
			    .createInfo()
			    .withCaption("Bilgi")
			    .withMessage("Kayıt Yapılıyor!")
			    .withOkButton(() -> System.out.println("kayıt Ok pressed."))
			    .open();
				hasarService.saveHasar(hasar);
				HasarIslem hasarIslem = new HasarIslem(); 
				hasarIslem.setHasar(hasar);
				VaadinUI.get().getHasarIslemService().save(hasarIslem);
				fieldGroup.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		horizontalLayout.addComponent(saveButton);
		horizontalLayout.setSizeFull();
		return horizontalLayout;
	}

	@Override
	public void enter(ViewChangeEvent event) {
		if (event.getParameters().length() > 0 && event.getParameters().contains("custom")) {
			removeAllComponents();
			// MTable<CustomJobModel> jobTable = new
			// MTable<CustomJobModel>(CustomJobModel.class)
			// .withProperties("jobName","description","teamname")
			// .setBeans(hasarService.findCustomJobModels());
			// jobTable.setWidth("100%");
			// addComponent(jobTable);
		} else {
			removeAllComponents();
			initLayout();
		}
	}

}
