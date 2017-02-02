package com.au.example.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.au.example.model.User;
import com.au.example.repo.UserRepository;
import com.vaadin.annotations.Theme;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Grid;
import com.vaadin.ui.UI;


@SpringUI(path="crawlerUI")
@Theme("valo")
public class CrawlerUI extends UI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2934157708922328870L;
	
	UserRepository repo;
	Grid grid;
	
    @Autowired
    public CrawlerUI(UserRepository repo) {
        this.repo = repo;
        this.grid = new Grid();
    }

    @Override
    protected void init(VaadinRequest request) {
        setContent(grid);
        listCustomers();
    }

    private void listCustomers() {
        grid.setContainerDataSource(
                new BeanItemContainer(User.class, repo.findAll()));
    }
}