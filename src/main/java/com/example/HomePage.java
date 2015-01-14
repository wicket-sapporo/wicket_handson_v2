package com.example;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

import com.example.easy.ui.EasyTaskSubmitPage;

public class HomePage extends WebPage {
	private static final long serialVersionUID = -3854045816940988685L;

	public HomePage() {
		add(new BookmarkablePageLink<Void>("easyTaskListPage", EasyTaskSubmitPage.class));
	}

}
