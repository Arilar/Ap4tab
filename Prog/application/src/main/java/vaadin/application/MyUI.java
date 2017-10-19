package vaadin.application;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Navigator navigator;
    protected static final String MAINVIEW = "main";
    private BinPerson person;
    

    public BinPerson getPerson() {
		return person;
	}
    
    

	@Override
    protected void init(VaadinRequest vaadinRequest) {
        
        navigator = new Navigator(this, this);
        navigator.addView("", new UiSelecter(this));
        navigator.addView("UiLogin", new UiLogin(this));
        navigator.addView("UiPatient", new UiPatient(this));
        navigator.addView("UiRegister", new UiRegister(this));
        
    }
	
	
    
    protected boolean login(String username, String password) {
    	return true;
/*    	if (true) { //test connexion sucessfull
    		//add Person to binPerson
			return true;
		} else {
			return false;
		}*/
    }
    
    protected boolean testCon() {
    	//TEST PERSON
    	person = new BinPatient("usrName", "123", "Mr.", "Test", "TestVorname", "test@me.ch", "+313243215", "BFH-Strasse 25", "Biel", 2500, "756.2131.22.11", "Assura", "Assurastreet 22", 1700, "Fribourg");
    	if (person.equals(null)) {
			return false;
		} else {
			return true;
		}
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
		case "UiPatient":
			try {
				navigator.removeView(target);
			} finally {
				navigator.addView(target, new UiPatient(this));
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

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
    }
}
