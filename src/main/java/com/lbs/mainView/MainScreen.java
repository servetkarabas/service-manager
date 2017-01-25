package com.lbs.mainView;

import com.lbs.VaadinUI;
import com.lbs.vaadin.view.HasarIhbarView;
import com.lbs.vaadin.view.HasarListView;
import com.lbs.vaadin.view.HasarView;
import com.lbs.vaadin.view.RaporView;
import com.lbs.vaadin.view.RoleView;
import com.lbs.vaadin.view.SearchView;
import com.lbs.vaadin.view.UserView;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;

/**
 * Content of the UI when the user is logged in.
 * 
 * 
 */
public class MainScreen extends HorizontalLayout {
    private Menu menu;
    static	Navigator navigator;
    
    public static Navigator getNavigator() {
		return navigator;
	}

	public MainScreen(VaadinUI ui) {

        setStyleName("main-screen");

        CssLayout viewContainer = new CssLayout();
        viewContainer.addStyleName("valo-content");
        viewContainer.setSizeFull();

        navigator = new Navigator(ui, viewContainer);
        navigator.setErrorView(ErrorView.class);
        menu = new Menu(navigator);
        menu.addView(new HasarIhbarView(), HasarIhbarView.VIEW_NAME,HasarIhbarView.VIEW_NAME, FontAwesome.BUILDING_O );
        menu.addView(new SearchView(), SearchView.VIEW_NAME,SearchView.VIEW_NAME, FontAwesome.CAMERA );
        menu.addView(new HasarView(), HasarView.VIEW_NAME,HasarView.VIEW_NAME, FontAwesome.ANDROID );
        menu.addView(new HasarListView(), HasarListView.VIEW_NAME,HasarListView.VIEW_NAME, FontAwesome.EDIT);
        menu.addView(new UserView(), UserView.VIEW_NAME,UserView.VIEW_NAME, FontAwesome.ADJUST );
        menu.addView(new RoleView(), RoleView.VIEW_NAME,RoleView.VIEW_NAME, FontAwesome.AMBULANCE );
        menu.addView(new RaporView(), RaporView.VIEW_NAME,RaporView.VIEW_NAME, FontAwesome.BRIEFCASE );
        menu.addView(new AboutView(), AboutView.VIEW_NAME, AboutView.VIEW_NAME,FontAwesome.INFO_CIRCLE);

        navigator.addViewChangeListener(viewChangeListener);
        
        addComponent(menu);
        addComponent(viewContainer);
        setExpandRatio(viewContainer, 1);
        setSizeFull();
    }

    // notify the view menu about view changes so that it can display which view
    // is currently active
    ViewChangeListener viewChangeListener = new ViewChangeListener() {
        @Override
        public boolean beforeViewChange(ViewChangeEvent event) {
            return true;
        }
        @Override
        public void afterViewChange(ViewChangeEvent event) {
            menu.setActiveView(event.getViewName());
        }
    };
}
