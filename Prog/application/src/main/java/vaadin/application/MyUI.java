package vaadin.application;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {
	
	//hey

	public Navigator navigator;
    protected static final String MAINVIEW = "main";


    @Override
    protected void init(VaadinRequest vaadinRequest) {
        
        navigator = new Navigator(this, this);
        navigator.addView("", new UiSelecter(this));
        navigator.addView("UiLogin", new UiLogin(this));
        navigator.addView("UiPatient", new UiPatient());
        navigator.addView("UiRegister", new UiRegister(this));
        
    }
    
    public void navigateTo(String target) {
    	
    	switch (target) {
		case "UiRegister":
			try {
				navigator.removeView(target);
			} finally {
				navigator.addView(target, new UiRegister(this));
			}
			break;
		case "UiLogin":
			try {
				navigator.removeView(target);
			} finally {
				navigator.addView(target, new UiLogin(this));
			}
			break;
		case "":
			try {
				navigator.removeView(target);
			} finally {
				navigator.addView(target, new UiSelecter(this));
			}
			break;

		default:
			break;
		}
    	
    	navigator.navigateTo(target);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
