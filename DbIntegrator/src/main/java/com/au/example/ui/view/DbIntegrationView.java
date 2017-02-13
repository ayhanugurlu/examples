package com.au.example.ui.view;

import com.au.example.base.DBType;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;

import java.util.Arrays;

/**
 * Created by ayhanu on 2/13/17.
 */
public class DbIntegrationView extends  CustomComponent implements View {


    public static final String NAME = "DbIntegrationView";

    private TwinColSelect selectTable;

    private Button acceptButton;


    public void init() {

        VerticalLayout layout = new VerticalLayout();

        selectTable = new TwinColSelect();
        selectTable.setNullSelectionAllowed(true);
        selectTable.setMultiSelect(true);
        selectTable.setImmediate(true);
        selectTable.setLeftColumnCaption("Source Table List");
        selectTable.setRightColumnCaption("Target Table List");



        selectTable.addValueChangeListener(e -> Notification.show("Value changed:",
                String.valueOf(e.getProperty().getValue()),
                Notification.Type.TRAY_NOTIFICATION));


        acceptButton = new Button("Select", clickEvent -> {

        });

        layout.addComponent(selectTable);
        layout.addComponent(acceptButton);

        setSizeFull();
        setCompositionRoot(layout);

    }


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        selectTable.focus();
    }
}
