package com.lbs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lbs.login.LoginScreen;
import com.lbs.login.LoginScreen.LoginListener;
import com.lbs.loginEx.Authentication;
import com.lbs.model.Hasar;
import com.lbs.service.DurumService;
import com.lbs.service.HasarDurumService;
import com.lbs.service.HasarIslemService;
import com.lbs.service.HasarService;
import com.lbs.service.MagazaService;
import com.lbs.service.RoleService;
import com.lbs.service.ServisService;
import com.lbs.service.UserService;
import com.lbs.vaadin.view.HasarView;
import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;

//@Theme("valo")  // vaadin theme
@Theme("mockapp")
@Widgetset("com.lbs.LBSWidgetSet")
@SpringUI(path="/*")  //spring boot & vaadin
@Component(value="ui")  // spring component
@PreserveOnRefresh
public class VaadinUI extends UI{
	private static final long serialVersionUID = -1791827648960086492L;
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private HasarService hasarService;
	@Autowired
	private MagazaService magazaService;
	@Autowired
	private DurumService durumService;
	
	@Autowired
	private ServisService servisService;
	
	@Autowired
	private HasarIslemService hasarIslemService;
	
	@Autowired
	private HasarDurumService hasarDurumService;
	
	private Hasar hasar;
	
    private com.lbs.login.AccessControl accessControl = new com.lbs.login.BasicAccessControl();
	public static Authentication AUTH;
	@Override
	protected void init(VaadinRequest vaadinRequest) {
        Responsive.makeResponsive(this);
        setLocale(vaadinRequest.getLocale());
        getPage().setTitle("Hasar Yönetim Sistemi");
        if (!accessControl.isUserSignedIn()) {
            setContent(new LoginScreen(accessControl, new LoginListener() {
                @Override
                public void loginSuccessful() {
                    showMainView();
                }
            }));
        } else {
            showMainView();
        }			
	}

    protected void showMainView() {
        addStyleName(ValoTheme.UI_WITH_MENU);
        setContent(new com.lbs.mainView.MainScreen(VaadinUI.this));
        getNavigator().navigateTo(HasarView.VIEW_NAME);
    }

	public UserService getUserService() {
		return userService;
	}


	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	public RoleService getTeamService() {
		return roleService;
	}


	public void setTeamService(RoleService teamService) {
		this.roleService = teamService;
	}
	
	public static VaadinUI get(){
		return (VaadinUI) VaadinUI.getCurrent();
	}

    public com.lbs.login.AccessControl getAccessControl() {
        return accessControl;
    }

    public HasarService getHasarService() {
		return hasarService;
	}

	public void setHasarService(HasarService hasarService) {
		this.hasarService = hasarService;
	}

	public RoleService getRoleService() {
		return	roleService;
	}

	public MagazaService getMagazaService() {
		return magazaService;
	}

	public DurumService getDurumService() {
		return	durumService;
	}

	public Hasar getHasar() {
		return hasar;
	}

	public void setHasar(Hasar hasar) {
		this.hasar = hasar;
	}

	public ServisService getServisService() {
		// TODO Auto-generated method stub
		return servisService;
	}

	public HasarIslemService getHasarIslemService() {
		return	hasarIslemService;
	}

	public HasarDurumService getHasarDurumService() {
		// TODO Auto-generated method stub
		return hasarDurumService;
	}

}
