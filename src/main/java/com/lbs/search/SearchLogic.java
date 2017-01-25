package com.lbs.search;

import org.springframework.beans.factory.annotation.Autowired;

import com.lbs.service.HasarService;
import com.lbs.vaadin.view.SearchView;

/**
 * This class provides an interface for the logical operations between the CRUD
 * view, its parts like the product editor form and the data source, including
 * fetching and saving products.
 *
 * Having this separate from the view makes it easier to test various parts of
 * the system separately, and to e.g. provide alternative views for the same
 * data.
 */
public class SearchLogic {

    private SearchView view;
    @Autowired
    private HasarService hasarService;

    public SearchLogic(SearchView simpleCrudView) {
        view = simpleCrudView;
    }


}
