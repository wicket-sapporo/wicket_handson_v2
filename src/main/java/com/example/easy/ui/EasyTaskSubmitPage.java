package com.example.easy.ui;

import java.util.List;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import com.example.MySession;

public class EasyTaskSubmitPage extends WebPage {
	private static final long serialVersionUID = -868830120298241539L;

	// 入力用のModelを用意する. FormのonSubmitから参照するので、フィールド変数.
	private IModel<String> taskModel;

	public EasyTaskSubmitPage() {

		taskModel = new Model<>("");

		// コンポーネントがMySessionのtasks変数を参照できるModelを準備する.
		IModel<List<String>> subemitedTasksModel = new PropertyModel<>(MySession.get(), "tasks");

		Form<Void> form = new Form<Void>("form") {
			private static final long serialVersionUID = -6755298559930288032L;

			@Override
			protected void onSubmit() {
				super.onSubmit();
				// 送信された値をMySessionのTasks変数に追加する.
				MySession.get().getTasks().add(taskModel.getObject());
			}
		};
		add(form);
		form.add(new TextField<String>("task", taskModel));

		// PropertyModelでMySessionのtasks変数を表示する.
		add(new ListView<String>("submitedTasks", subemitedTasksModel) {
			private static final long serialVersionUID = 7567522805582013827L;

			@Override
			protected void populateItem(ListItem<String> item) {
				item.add(new Label("submitedTask", item.getModel()));
			}
		});

		add(new Link<Void>("easyTaskRemovePage") {
			private static final long serialVersionUID = -2489854214191262719L;

			@Override
			public void onClick() {
				setResponsePage(new EasyTaskRemovePage());
			}
		});
	}

}
