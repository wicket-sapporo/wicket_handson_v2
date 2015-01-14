package com.example.easy.ui;

import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RadioChoice;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import com.example.MySession;

public class EasyTaskRemovePage extends WebPage {
	private static final long serialVersionUID = -7219883536246424520L;

	private IModel<String> removeTaskModel;

	public EasyTaskRemovePage() {

		removeTaskModel = new Model<>("");
		IModel<List<String>> subemitedTasksModel = new PropertyModel<>(MySession.get(), "tasks");

		Form<Void> form = new Form<Void>("form") {
			private static final long serialVersionUID = -5008896766151203218L;

			@Override
			protected void onSubmit() {
				super.onSubmit();
				MySession.get().getTasks().remove(removeTaskModel.getObject());
			}
		};
		add(form);

		form.add(new RadioChoice<String>("removeTask", removeTaskModel, subemitedTasksModel));

		add(new BookmarkablePageLink<Void>("easyTaskSubmitPage", EasyTaskSubmitPage.class));
	}

}
