package com.example;

import org.apache.wicket.Page;
import org.apache.wicket.Session;
import org.apache.wicket.core.request.mapper.MountedMapper;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
import org.apache.wicket.request.mapper.parameter.UrlPathPageParametersEncoder;

import com.example.easy.ui.EasyTaskSubmitPage;

/**
 * Application object for your web application.
 * If you want to run this application without deploying, run the Start class.
 * 
 * @see com.example.Start#main(String[])
 */
public class WicketApplication extends WebApplication {

	@Override
	public Class<? extends WebPage> getHomePage() {
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init() {
		super.init();
		getRequestCycleSettings().setResponseRequestEncoding("UTF-8");
		getMarkupSettings().setDefaultMarkupEncoding("UTF-8");
		mountPage(HomePage.class);
		mountPage(EasyTaskSubmitPage.class);
	}

	@Override
	public Session newSession(Request request, Response response) {
		return new MySession(request);
	}

	public void mountPage(Class<? extends Page> pageClass) {
		mount(new MountedMapper("/" + pageClass.getSimpleName(), pageClass, new UrlPathPageParametersEncoder()));
	}

}
