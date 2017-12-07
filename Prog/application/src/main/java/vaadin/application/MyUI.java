package vaadin.application;

import java.lang.reflect.Array;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
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
	
	
	//Test Burcu

	// hey

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Navigator navigator;
	protected static final String MAINVIEW = "main";
	private BinPerson person;
	private ArrayList<BinTermin> allTerms = new ArrayList<>();

	public BinPerson getPerson() {
		return person;
	}

	public ArrayList<BinTermin> getAllTerms() {
		ArrayList<BinTermin> result = new ArrayList<>();

		for (BinTermin binTermin : allTerms) {
			if (person instanceof BinPerson) {
				if (binTermin.getPatient().equals((BinPatient) person)) {
					result.add(binTermin);
				}
			}
			if (person instanceof BinMedicalStaff) {
				if (binTermin.getMed().equals((BinMedicalStaff) person)) {
					result.add(binTermin);
				}
			}
		}
		Collections.sort(result, new TerminComparatorDate());
		allTerms = result;
		return allTerms;
	}

	@Override
	protected void init(VaadinRequest vaadinRequest) {

		navigator = new Navigator(this, this);
		navigator.addView("", new UiSelecter(this));
		navigator.addView("UiLogin", new UiLogin(this));
		navigator.addView("UiPatient", new UiPatient(this));
		navigator.addView("UiRegister", new UiRegister(this));
		navigator.addView("UiShortList", new UiShortList(this));
		navigator.addView("UiMoreList", new UiMoreList(this));

	}

	private void adddata() {
		person = new BinPatient("usrName", "123", "Mr.", "Test", "TestVorname", new DateL(1992, 10, 21), "test@me.ch",
				"+313243215", "BFH-Strasse 25", "Biel", 2500, "756.2131.22.11", "Assura", "Assurastreet 22", 1700,
				"Fribourg");

		allTerms.add(0,
				new BinTermin(
						new BinMedicalStaff("logMed", "123med", "Dr", "Arzt", "vornameArzt", new DateL(1950, 05, 12),
								"dr@med.ch", "0765625341", "Hospitalstreet", "MedizinCity", 2311, "7601640333111",
								"Kantonsspital", "Kantonsspitaladresse", 2331, "SpitalStadt"),
						new BinType("#321232", "red", "Pending"), (BinPatient) person, new DateL(2017, 12, 10, 13, 30),
						30, "Terminbeschreibung", "Saal 111"));
		allTerms.add(1,
				new BinTermin(
						new BinMedicalStaff("logMed2", "123med2", "Dr", "Arzt2", "vornameArzt2", new DateL(1961, 06, 8),
								"dr@med.ch2", "0765625341", "Hospitalstreet2", "MedizinCity2", 2311, "7601640333222",
								"Kantonsspital2", "Kantonsspitaladresse2", 2331, "SpitalStadt2"),
						new BinType("#321232", "red", "Pending"), (BinPatient) person, new DateL(2017, 12, 11, 10, 00),
						30, "Terminbeschreibung2", "Saal 222"));
		allTerms.add(1,
				new BinTermin(
						new BinMedicalStaff("logMed2", "123med2", "Dr", "Arzt2", "vornameArzt2", new DateL(1961, 06, 8),
								"dr@med.ch2", "0765625341", "Hospitalstreet2", "MedizinCity2", 2311, "7601640333222",
								"Kantonsspital2", "Kantonsspitaladresse2", 2331, "SpitalStadt2"),
						new BinType("#321232", "red", "Pending"), (BinPatient) person, new DateL(2016, 12, 11, 10, 00),
						30, "Terminbeschreibung2", "Saal XX"));
		allTerms.add(2,
				new BinTermin(
						new BinMedicalStaff("logMed3", "123med3", "Dr3", "Arzt3", "vornameArzt3",
								new DateL(1976, 01, 15), "dr@med.ch3", "0765625341", "Hospitalstreet3", "MedizinCity3",
								2311, "7601640333333", "Kantonsspital3", "Kantonsspitaladresse3", 2331, "SpitalStadt3"),
						new BinType("#321232", "red", "Pending"), (BinPatient) person, new DateL(2017, 12, 8, 18, 15),
						30, "Terminbeschreibung3", "Saal 333"));

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
		this.adddata();
		if (person.equals(null)) {
			return false;
		} else {
			return true;
		}
	}

	protected ArrayList<BinTermin> getAllTermsfrom(Timestamp date) {
		ArrayList<BinTermin> listfrom = new ArrayList<>();
		listfrom = getAllTermsSorted();
		ArrayList<BinTermin> nextTerms = new ArrayList<>();
		
		for (int i = 0; i < listfrom.size(); i++) {
			if(listfrom.get(i).getConsultation().compareTo(date) > 0) {
				nextTerms.add(listfrom.get(i));
			}
		}
		return nextTerms;
	}
	
	

	public ArrayList<BinTermin> getAllTermsSorted() {
		Collections.sort(allTerms, new TerminComparatorDate());
		return allTerms;
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
				navigator.addView(target, new UiShortList(this));
			}
			break;
		// UiMoreList
		case "UiMoreList":
			try {
				navigator.removeView(target);
			} finally {
				navigator.addView(target, new UiMoreList(this));
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
