package com.au.example.view;

import java.util.List;

import org.springframework.util.StringUtils;

import com.au.example.model.UrlHtmlTag;
import com.au.example.repo.UrlHtmlTagRepository;
import com.au.example.service.ICrawler;
import com.au.example.ui.editor.UrlHtmlTagEditor;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class UrlHtmlTagView extends CustomComponent implements View, Button.ClickListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3998079804411986508L;

	public static final String NAME = "urlHtmlTagView";

	private UrlHtmlTagRepository repo;

	private UrlHtmlTagEditor editor;

	private ICrawler crawler;

	final Grid grid;

	final TextField filter;

	final Button logout;

	final Button startCrawler;

	private final Button addNewBtn;

	public UrlHtmlTagView() {

		this.grid = new Grid();
		this.filter = new TextField();
		this.addNewBtn = new Button("New Url", FontAwesome.PLUS);
		logout = new Button("Logout", new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {

				// "Logout" the user
				getSession().setAttribute("user", null);

				// Refresh this view, should redirect to login view
				getUI().getNavigator().navigateTo(NAME);
			}
		});
		startCrawler = new Button("Start Crawler", new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				List<UrlHtmlTag> htmlTags = repo.findAll();
				for (UrlHtmlTag tag : htmlTags) {
					crawler.scan(tag.getUrl());
				}

			}
		});
	}

	public void init(UrlHtmlTagRepository repo, UrlHtmlTagEditor editor, ICrawler iCrawler) {
		setSizeFull();
		this.repo = repo;
		this.editor = editor;
		this.crawler = iCrawler;
		// build layout
		HorizontalLayout actions = new HorizontalLayout(filter, addNewBtn, startCrawler);
		VerticalLayout mainLayout = new VerticalLayout(logout, actions, grid, editor);
		setCompositionRoot(mainLayout);

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
			} else {
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
			grid.setContainerDataSource(new BeanItemContainer(UrlHtmlTag.class, repo.findAll()));
		} else {
			grid.setContainerDataSource(new BeanItemContainer(UrlHtmlTag.class, repo.findByUrlStartsWithIgnoreCase(text)));
		}
	}

	// end::listUrlHtmlTag[]

	@Override
	public void buttonClick(ClickEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub

	}
}