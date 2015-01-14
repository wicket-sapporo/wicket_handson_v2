package com.example;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

public class TestHomePage {
	private WicketTester tester;

	@Before
	public void setUp() {
		tester = new WicketTester(new WicketApplication());
	}

	@Test
	public void 表示される() {
		tester.startPage(HomePage.class);
		tester.assertRenderedPage(HomePage.class);
	}
}
