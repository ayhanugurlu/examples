package com.au.example.ui.editor;

import org.springframework.beans.factory.annotation.Autowired;

import com.au.example.model.UrlHtmlTag;
import com.au.example.repo.UrlHtmlTagRepository;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.event.ShortcutAction;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.VaadinSessionScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@SpringComponent
@VaadinSessionScope
public class UrlHtmlTagEditor extends  VerticalLayout {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1977906192529760933L;

	private final UrlHtmlTagRepository repository;

	/**
	 * The currently edited urlHtmlTag
	 */
	private UrlHtmlTag urlHtmlTag;

	/* Fields to edit properties in UrlHtmlTag entity */
	TextField url = new TextField("Crawl Url");
	TextField htmlTag = new TextField("Html Tag");

	/* Action buttons */
	Button save = new Button("Save", FontAwesome.SAVE);
	Button cancel = new Button("Cancel");
	Button delete = new Button("Delete", FontAwesome.TRASH_O);
	CssLayout actions = new CssLayout(save, cancel, delete);

	@Autowired
	public UrlHtmlTagEditor(UrlHtmlTagRepository repository) {
		this.repository = repository;

		addComponents(url, htmlTag, actions);

		// Configure and style components
		setSpacing(true);
		actions.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
		save.setStyleName(ValoTheme.BUTTON_PRIMARY);
		save.setClickShortcut(ShortcutAction.KeyCode.ENTER);

		// wire action buttons to save, delete and reset
		save.addClickListener(e -> repository.save(urlHtmlTag));
		delete.addClickListener(e -> repository.delete(urlHtmlTag));
		cancel.addClickListener(e -> editUrlHtmlTag(urlHtmlTag));
		setVisible(false);
	}

	public interface ChangeHandler {

		void onChange();
	}

	public final void editUrlHtmlTag(UrlHtmlTag u) {
		final boolean persisted = u.getId() != null;
		if (persisted) {
			// Find fresh entity for editing
			urlHtmlTag = repository.findOne(u.getId());
		}
		else {
			urlHtmlTag = u;
		}
		cancel.setVisible(persisted);

		// Bind urlHtmlTag properties to similarly named fields
		// Could also use annotation or "manual binding" or programmatically
		// moving values from fields to entities before saving
		BeanFieldGroup.bindFieldsUnbuffered(urlHtmlTag, this);

		setVisible(true);

		// A hack to ensure the whole form is visible
		save.focus();
		// Select all text in firstName field automatically
		url.selectAll();
	}

	public void setChangeHandler(ChangeHandler h) {
		// ChangeHandler is notified when either save or delete
		// is clicked
		save.addClickListener(e -> h.onChange());
		delete.addClickListener(e -> h.onChange());
	}

}