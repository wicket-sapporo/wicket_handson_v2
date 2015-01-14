package com.example.ui;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.apache.wicket.util.tester.FormTester;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

import com.example.MySession;
import com.example.WicketApplication;
import com.example.easy.ui.EasyTaskRemovePage;
import com.example.easy.ui.EasyTaskSubmitPage;

public class TestEasyTaskSubmitPage {
	private WicketTester tester;

	@Before
	public void setUp() {
		tester = new WicketTester(new WicketApplication());
	}

	@Test
	public void 表示される() {
		tester.startPage(EasyTaskSubmitPage.class);
		tester.assertRenderedPage(EasyTaskSubmitPage.class);
		tester.executeUrl("/EasyTaskSubmitPage");
	}

	@Test
	public void Formを送信するとSessionに追加されてListViewに表示される() {
		tester.startPage(EasyTaskSubmitPage.class);
		FormTester formTester = tester.newFormTester("form");
		formTester.setValue("task", "abcd");
		formTester.submit();

		List<String> tasks = ((MySession) tester.getSession()).getTasks();
		assertThat(tasks.size(), is(1));
		assertThat(tasks.get(0), is("abcd"));
		tester.assertLabel("submitedTasks:0:submitedTask", "abcd");
	}
	
	@Test
	public void EasyTaskRemovePageに移動できる() {
		tester.startPage(EasyTaskSubmitPage.class);
		tester.clickLink("easyTaskRemovePage");
		tester.assertRenderedPage(EasyTaskRemovePage.class);
	}
}
