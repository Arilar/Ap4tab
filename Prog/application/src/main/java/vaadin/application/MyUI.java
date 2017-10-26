package vaadin.application;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

/**
 * This UI is the application entry point. A UI may either represent a browser
 * window (or tab) or some part of an HTML page where a Vaadin application is
 * embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is
 * intended to be overridden to add component to the user interface and
 * initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

	// hey

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Navigator navigator;
	protected static final String MAINVIEW = "main";
	private BinPerson person;
	private ArrayList<BinTermin> allTerms = new ArrayList<>(10);

	public BinPerson getPerson() {
		return person;
	}

	public ArrayList<BinTermin> getAllTerms() {
		return allTerms;
	}

	@Override
	protected void init(VaadinRequest vaadinRequest) {

		navigator = new Navigator(this, this);
		navigator.addView("", new UiSelecter(this));
		navigator.addView("UiLogin", new UiLogin(this));
		navigator.addView("UiPatient", new UiPatient(this));
		navigator.addView("UiRegister", new UiRegister(this));
		navigator.addView("UiShortList", new UIShortList(this));


	}

	protected boolean login(String username, String password) {
		return true;
		/*
		 * if (true) { //test connexion sucessfull //add Person to binPerson
		 * getAllTerms(this.person); return true; } else { return false; }
		 */
	}

	protected boolean testCon() {
		// TEST PERSON
		person = new BinPatient("usrName", "123", "Mr.", "Test", "TestVorname", new Date(21, 10, 1992), "test@me.ch",
				"+313243215", "BFH-Strasse 25", "Biel", 2500, "756.2131.22.11", "Assura", "Assurastreet 22", 1700,
				"Fribourg");
		if (person.equals(null)) {
			return false;
		} else {
			getAllTerms(person);
			return true;
		}
	}

	@SuppressWarnings("deprecation")
	protected void getAllTerms(BinPerson pers) {
		if (pers instanceof BinPatient) {
			BinPatient person = (BinPatient) pers;
			allTerms.add(0,
					new BinTermin(
							new BinMedicalStaff("logMed", "123med", "Dr", "Arzt", "vornameArzt", new Date(1960, 12, 25),
									"dr@med.ch", "0765625341", "Hospitalstreet", "MedizinCity", 2311, "7601640333111",
									"Kantonsspital", "Kantonsspitaladresse", 2331, "SpitalStadt"),
							new BinType("#321232", "red"), person, new Date(2017, 10, 29, 22, 13), 30,
							"Terminbeschreibung", "Saal 111"));
			allTerms.add(1,
					new BinTermin(new BinMedicalStaff("logMed2", "123med2", "Dr", "Arzt2", "vornameArzt2",
							new Date(1960, 12, 25), "dr@med.ch2", "0765625341", "Hospitalstreet2", "MedizinCity2", 2311,
							"7601640333222", "Kantonsspital2", "Kantonsspitaladresse2", 2331, "SpitalStadt2"),
							new BinType("#321232", "red"), person, new Date(2017, 10, 28, 22, 13), 30,
							"Terminbeschreibung2", "Saal 222"));
			allTerms.add(2,
					new BinTermin(new BinMedicalStaff("logMed3", "123med3", "Dr3", "Arzt3", "vornameArzt3",
							new Date(1960, 12, 25), "dr@med.ch3", "0765625341", "Hospitalstreet3", "MedizinCity3", 2311,
							"7601640333333", "Kantonsspital3", "Kantonsspitaladresse3", 2331, "SpitalStadt3"),
							new BinType("#321232", "red"), person, new Date(2017, 30, 30, 22, 13), 30,
							"Terminbeschreibung3", "Saal 333"));

			// GetallTermins
			// set it into allTerms
		}
		if (pers instanceof BinMedicalStaff) {
			BinMedicalStaff person = (BinMedicalStaff) pers;
			// GetallTermins
			// set it into allTerms
		}

		// toremoveAfterThis

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
		case "UiShortList":
			try {
				navigator.removeView(target);
			} finally {
				navigator.addView(target, new UIShortList(this));
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
