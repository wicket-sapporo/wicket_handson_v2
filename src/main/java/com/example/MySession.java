package com.example;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;

public class MySession extends WebSession {
	private static final long serialVersionUID = -4449492463774193365L;

	private List<String> tasks;

	public static MySession get() {
		return (MySession) WebSession.get();
	}

	public MySession(Request request) {
		super(request);
		tasks = new ArrayList<String>();
	}

	public List<String> getTasks() {
		return tasks;
	}

}
