package com.au.example.ui.view;

import com.au.example.base.DBType;
import com.au.example.data.ConnectionParam;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;

import java.util.Arrays;

/**
 * Created by ayhanu on 2/13/17.
 */
public class DbSelectionView extends CustomComponent implements View {

        public static final String NAME = "DbSelectionView";


    private ComboBox dbComboBoxSource;
    private ComboBox dbComboBoxTarget;

    private TextField sourceDbConnectionUrl;
    private TextField sourceUserName;
    private TextField sourcePassword;

    private TextField targetDbConnectionUrl;
    private TextField targetUserName;
    private TextField targetPassword;


    private Button testSourceConnetionButton;
    private Button testTargetConnetionButton;
    private Button acceptButton;

    private ConnectionParam sourceConnectionParam;

    private ConnectionParam targetConnectionParam;


    public void init() {

        GridLayout gridLayout = new GridLayout();
        gridLayout.setRows(4);
        gridLayout.setColumns(3);

        gridLayout.setSizeFull();
        ;


        dbComboBoxSource = new ComboBox("Select Source Database Type", Arrays.asList(DBType.values()));


        dbComboBoxTarget = new ComboBox("Select Target Database Type", Arrays.asList(DBType.values()));

        gridLayout.addComponent(dbComboBoxSource, 0, 0);
        gridLayout.addComponent(dbComboBoxTarget, 0, 1);


        sourceDbConnectionUrl = new TextField("SourceDb Connection Url");
        sourceUserName = new TextField("SourceDb User Name");
        sourcePassword = new TextField("SourceDb Password");

        gridLayout.addComponent(sourceDbConnectionUrl, 1, 0);
        gridLayout.addComponent(sourceUserName, 1, 1);
        gridLayout.addComponent(sourcePassword, 1, 2);


        testSourceConnetionButton = new Button("Test Connetion", clickEvent -> {

        });

        gridLayout.addComponent(testSourceConnetionButton, 1, 3);


        targetDbConnectionUrl = new TextField("TargetDb Connection Url");
        targetUserName = new TextField("TargetDb User Name");
        targetPassword = new TextField("TargetDb Password");


        gridLayout.addComponent(targetDbConnectionUrl, 2, 0);
        gridLayout.addComponent(targetUserName, 2, 1);
        gridLayout.addComponent(targetPassword, 2, 2);


        testTargetConnetionButton = new Button("Test Connetion", clickEvent -> {

        });

        gridLayout.addComponent(testTargetConnetionButton, 2, 3);

        acceptButton = new Button("Select", clickEvent -> {
            sourceConnectionParam = new ConnectionParam(sourceDbConnectionUrl.getValue(),sourceUserName.getValue(),sourcePassword.getValue());
            targetConnectionParam = new ConnectionParam(targetDbConnectionUrl.getValue(),targetUserName.getValue(),targetPassword.getValue());
            getUI().getNavigator().navigateTo(DbIntegrationView.NAME);
        });

        gridLayout.addComponent(acceptButton, 3, 3);
        setCompositionRoot(gridLayout);


    }


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        dbComboBoxSource.focus();
    }


    public ConnectionParam getSourceConnectionParam() {
        return sourceConnectionParam;
    }

    public ConnectionParam getTargetConnectionParam() {
        return targetConnectionParam;
    }
}
