package com.au.example.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.au.example.model.UrlHtmlTag;
import com.au.example.repo.UrlHtmlTagRepository;
import com.au.example.ui.editor.UrlHtmlTagEditor;
import com.vaadin.annotations.Theme;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI(path = "addUrlUI")
@Theme("valo")
public class AddUrlUI extends UI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2934157708922328870L;

	UrlHtmlTagRepository repo;
	
	private final UrlHtmlTagEditor editor;

	final Grid grid;

	final TextField filter;
	
	private final Button addNewBtn;
	

	@Autowired
	public AddUrlUI(UrlHtmlTagRepository repo,UrlHtmlTagEditor editor) {
		this.repo = repo;
		this.editor = editor;
		this.grid = new Grid();
		this.filter = new TextField();
		this.addNewBtn = new Button("New Url", FontAwesome.PLUS);
	}

	@Override
	protected void init(VaadinRequest request) {
		// build layout
		HorizontalLayout actions = new HorizontalLayout(filter, addNewBtn);
		VerticalLayout mainLayout = new VerticalLayout(actions, grid, editor);
		setContent(mainLayout);

		// Configure layouts and components
		actions.setSpacing(true);
		mainLayout.setMargin(true);
		mainLayout.setSpacing(true);

		grid.setHeight(300, Unit.PIXELS);
		grid.setColumns("id", "url", "htmlTag");

		filter.setInputPrompt("Filter by url");

		// Hook logic to components

		// Replace listing with filtered content when user changes filter
		filter.addTextChangeListener(e -> listUrlHtmlTag(e.getText()));

		// Connect selected Customer to editor or hide if none is selected
		grid.addSelectionListener(e -> {
			if (e.getSelected().isEmpty()) {
				editor.setVisible(false);
			}
			else {
				editor.editUrlHtmlTag((UrlHtmlTag) grid.getSelectedRow());
			}
		});

		// Instantiate and edit new Customer the new button is clicked
		addNewBtn.addClickListener(e -> editor.editUrlHtmlTag(new UrlHtmlTag("", "")));

		// Listen changes made by the editor, refresh data from backend
		editor.setChangeHandler(() -> {
			editor.setVisible(false);
			listUrlHtmlTag(filter.getValue());
		});

		// Initialize listing
		listUrlHtmlTag(null);
	}

	// tag::listUrlHtmlTag[]
	void listUrlHtmlTag(String text) {
		if (StringUtils.isEmpty(text)) {
			grid.setContainerDataSource(
					new BeanItemContainer(UrlHtmlTag.class, repo.findAll()));
		}
		else {
			grid.setContainerDataSource(new BeanItemContainer(UrlHtmlTag.class,
					repo.findByUrlStartsWithIgnoreCase(text)));
		}
	}
	// end::listUrlHtmlTag[]
}