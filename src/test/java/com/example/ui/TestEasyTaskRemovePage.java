package com.example.ui;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.apache.wicket.util.tester.FormTester;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

import com.example.MySession;
import com.example.WicketApplication;
import com.example.easy.ui.EasyTaskRemovePage;
import com.example.easy.ui.EasyTaskSubmitPage;

public class TestEasyTaskRemovePage {
	private WicketTester tester;

	@Before
	public void setUp() {
		tester = new WicketTester(new WicketApplication());
	}

	@Test
	public void 表示される() {
		tester.startPage(EasyTaskRemovePage.class);
		tester.assertRenderedPage(EasyTaskRemovePage.class);
	}

	@Test
	public void Formを送信するとSessionに追加されてListViewに表示される() {
		((MySession) tester.getSession()).getTasks().addAll(Arrays.asList("foo", "bar", "baz"));

		tester.startPage(EasyTaskRemovePage.class);
		FormTester formTester = tester.newFormTester("form");
		formTester.select("removeTask", 0);
		formTester.submit();

		List<String> tasks = ((MySession) tester.getSession()).getTasks();
		assertThat(tasks.size(), is(2));
		assertThat(tasks.get(0), is("bar"));
		assertThat(tasks.get(1), is("baz"));
	}

	@Test
	public void EasyTaskSubmitPageに移動できる() {
		tester.startPage(EasyTaskRemovePage.class);
		tester.clickLink("easyTaskSubmitPage");
		tester.assertRenderedPage(EasyTaskSubmitPage.class);
	}
}
