package com.au.example.ui;

import com.au.example.ui.view.DbIntegrationView;
import com.au.example.ui.view.DbSelectionView;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by ayhanu on 2/13/17.
 */

@SpringUI(path = "DBIntegrationUI")
@Theme("valo")
public class DBIntegrationUI  extends UI{

    public void init(VaadinRequest request){

        //
        // Create a new instance of the navigator. The navigator will attach
        // itself automatically to this view.
        //
        new Navigator(this, this);

        //
        // Add the main view of the application
        //
        getNavigator().addView(DbSelectionView.NAME, DbSelectionView.class);


        //
        // Add the main view of the application
        //
        getNavigator().addView(DbIntegrationView.NAME, DbIntegrationView.class);




        getNavigator().addViewChangeListener(new ViewChangeListener() {
            @Override
            public boolean beforeViewChange(ViewChangeEvent viewChangeEvent) {

                if(viewChangeEvent.getViewName().equals(DbSelectionView.NAME)){
                    DbSelectionView dbSelectionView = (DbSelectionView) viewChangeEvent.getNewView();
                    dbSelectionView.init();
                    return true;
                }

                if(viewChangeEvent.getViewName().equals(DbIntegrationView.NAME)){
                    DbIntegrationView dbIntegrationView = (DbIntegrationView) viewChangeEvent.getNewView();
                    dbIntegrationView.init();
                    return true;
                }

                return false;
            }

            @Override
            public void afterViewChange(ViewChangeEvent viewChangeEvent) {
                System.out.print("test");

            }
        });

    }

}
