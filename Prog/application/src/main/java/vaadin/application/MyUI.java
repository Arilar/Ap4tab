package vaadin.application;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
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

	// hey

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Navigator navigator;
	protected static final String MAINVIEW = "main";
	private BinPerson person;
	private BinCase casee;
	private BinMedicalStaff medstaffW;
	private BinMedicalStaff medstaffK;
	private BinMedicalStaff medstaffC;
	private BinMedicalStaff medstaffP;
	private ArrayList<BinTermin> allTerms = new ArrayList<>();
	private Calendar cal = Calendar.getInstance();
	private boolean loggedIn = false;
	public int steps=1;
	private int tester = 0;

	


	/**
	 * @return the tester
	 */
	public int getTester() {
		return tester;
	}

	/**
	 * @param tester the tester to set
	 */
	public void incTester() {
		if(steps==1) {
			steps++;
		}else if(steps==2) {
			if(tester==1) {
				steps++;
				tester=0;
			} else {
				tester++;
			}
		}else if(steps==3) {
			steps++;
		}else if(steps==4) {
			if(tester==2) {
				steps++;
				tester=0;
			} else {
				tester++;
			}
		}else if(steps==5) {
			if(tester==5) {
				steps++;
				tester=0;
			} else {
				tester++;
			}
		}
	}

	public BinPerson getPerson() {
		return person;
	}

	/**
	 * make a list for all terms for each person
	 * @return
	 */
	public ArrayList<BinTermin> getAllTerms() {
		ArrayList<BinTermin> result = new ArrayList<>();

		for (BinTermin binTermin : allTerms) {
			if (person instanceof BinPerson) {
				if (binTermin.getCaseID().getPatient().equals((BinPatient) person)) {
					result.add(binTermin);
				}
			}
			if (person instanceof BinMedicalStaff) {
				if (binTermin.getMed().equals((BinMedicalStaff) person)) {
					result.add(binTermin);
				}
			}
		}
		Collections.sort(result, new CalendarComparator());
		allTerms = result;
		return allTerms;
	}

	@Override
	protected void init(VaadinRequest vaadinRequest) {

		navigator = new Navigator(this, this);
		navigator.addView("", new UiLogin(this));
		navigator.addView("UiLogin", new UiLogin(this));
		navigator.addView("UiPatient", new UiPatient(this));
		navigator.addView("UiRegister", new UiRegister(this));
		navigator.addView("UiShortList", new UiShortList(this));
		navigator.addView("UiPastList", new UiListPast(this));
	}	

	private void adddata() {
		person = new BinPatient("Brönnimann", "Apps4Tab", "Frau", "Brönnimann", "Elisabeth", CalendarL.setCalendarYMA(1935, 10, 21), "brönnimann.elisabeth@bluewin.ch",
				"+41795562145", "BFH-Strasse 25", "Biel", 2500, "756.2131.22.11", "Assura", "Assurastreet 22", 2500,
				"Biel");
		medstaffW = new BinMedicalStaff("medic", "123456", "Dr", "Wenger", "Roger",CalendarL.setCalendarYMA(1950, 12, 1),
				"wenger.roger@med.ch", "0765625341", "Hospitalstreet", "MedizinCity", 2311, "7601640333111",
				"Kantonsspital", "Kantonsspitaladresse", 2331, "SpitalStadt");
		medstaffK = new BinMedicalStaff("medic", "234566", "Dr", "Knochenbrecher", "Ivan",CalendarL.setCalendarYMA(1950, 12, 1),
				"knochenbrecher.ivan@med.ch", "0790492040", "Rotestrasse", "Praxis Knochenbrecher", 86, "760100678789",
				"Praxis Knochenbrecher", "Rotestrasse", 2502, "Biel/Bienne");
		medstaffC = new BinMedicalStaff("medic", "083458", "Dr", "Mao-Tao", "Ling",CalendarL.setCalendarYMA(1950, 12, 1),
				"maotao-ling@med.ch", "0760947843", "Bahnhofstrasse", "MedizinCity", 234, "76010908976",
				"Spitalzentrum Biel", "Chante-Merle 84", 2501, "Biel/Bienne");
		medstaffP = new BinMedicalStaff("medic", "234084", "", "Van Denn", "Jean-Claude",CalendarL.setCalendarYMA(1950, 12, 1),
				"vandenn.jeanclaude@med.ch", "0784592034", "Mühlebrücke", "Physio Van Denn", 8, "76019068990",
				"Physio Van Denn", "Mühlebrücke", 2502, "Biel/Bienne");
		
		BinType caseType = new BinType("#121212", "Error", "in bearbeitung");
		casee= new BinCase("TestCase", caseType, 
				medstaffW, 
				(BinPatient) person, CalendarL.setCalendarYMA(2017, 10, 13), CalendarL.now());
		

		allTerms.add(0,
				new BinTermin(medstaffW, caseType, casee, CalendarL.setCalendarYMAHM(2018, 1, 11, 15, 30), 30, 
						"Konsultation", "Konsultationssaal 1"));
		allTerms.add(1,
				new BinTermin(medstaffK, caseType, casee, CalendarL.setCalendarYMAHM(2018, 1, 13, 15, 30), 15, 
						"CT linker Hüft", "Röntgensaal 3"));
		allTerms.add(2,
				new BinTermin(medstaffK, caseType, casee, CalendarL.setCalendarYMAHM(2018, 1, 15, 18, 15), 60, 
						"Konsultation mit dem Spezialist in Orthopädie", "Konsultationssaal 1"));
		allTerms.add(3,
				new BinTermin(medstaffC, caseType, casee, CalendarL.setCalendarYMAHM(2018, 2, 1, 8, 30), 10, 
						"Spitaleintritt", "Eingang 1"));
		allTerms.add(4,
				new BinTermin(medstaffC, caseType, casee, CalendarL.setCalendarYMAHM(2018, 2, 1, 9, 30), 30, 
						"Präoperative Untersuchung", "Konsultationssaal 3, 2. Stock"));
		allTerms.add(5,
				new BinTermin(medstaffC, caseType, casee, CalendarL.setCalendarYMAHM(2018, 2, 2, 16, 30), 120, 
						"Hüftprothesenersatz Operation", "Operationssaal 32b, Erdgeschoss"));
		allTerms.add(6,
				new BinTermin(medstaffC, caseType, casee, CalendarL.setCalendarYMAHM(2018, 2, 3, 10, 30), 30, 
						"Postoperative Untersuchung", "Konsultationssaal 2, 2. Stock"));
		allTerms.add(7,
				new BinTermin(medstaffP, caseType, casee, CalendarL.setCalendarYMAHM(2018, 2, 10, 7, 50), 45, 
						"Physiotherapie", "Physiosaal 2, 1. Stock"));
		allTerms.add(8,
				new BinTermin(medstaffP, caseType, casee, CalendarL.setCalendarYMAHM(2018, 2, 15, 7, 50), 45, 
						"Physiotherapie", "Physiosaal 2, 1. Stock"));
		allTerms.add(9,
				new BinTermin(medstaffP, caseType, casee, CalendarL.setCalendarYMAHM(2018, 2, 20, 7, 50), 45, 
						"Physiotherapie", "Physiosaal 2, 1. Stock"));
		allTerms.add(10,
				new BinTermin(medstaffP, caseType, casee, CalendarL.setCalendarYMAHM(2018, 2, 25, 7, 50), 45, 
						"Physiotherapie", "Physiosaal 2, 1. Stock"));
		allTerms.add(11,
				new BinTermin(medstaffP, caseType, casee, CalendarL.setCalendarYMAHM(2018, 2, 30, 7, 50), 45, 
						"Physiotherapie", "Physiosaal 2, 1. Stock"));
		allTerms.add(12,
				new BinTermin(medstaffK, caseType, casee, CalendarL.setCalendarYMAHM(2018, 3, 8, 9, 15), 45, 
						"Postoperative Kontrolle der Hüftprothese", "Konsultationssaal 1"));
		allTerms.get(0).setStep(1);
		allTerms.get(1).setStep(2);
		allTerms.get(2).setStep(2);
		allTerms.get(3).setStep(3);
		allTerms.get(4).setStep(4);
		allTerms.get(5).setStep(4);
		allTerms.get(6).setStep(4);
		allTerms.get(7).setStep(5);
		allTerms.get(8).setStep(5);
		allTerms.get(9).setStep(5);
		allTerms.get(10).setStep(5);
		allTerms.get(11).setStep(5);
		allTerms.get(12).setStep(5);
		

	}
	
	

	protected boolean login(String username, String password) {
		if(username.equals("Brönnimann") && password.equals("App4Tab")) {
		navigateTo("UiShortList");
		loggedIn=true;
		} 
		return loggedIn;
		/*
		 * if (true) { //test connexion sucessfull //add Person to binPerson
		 * getAllTerms(this.person); return true; } else { return false; }
		 */
	}
	
	

	/**
	 * @return the loggedIn
	 */
	public boolean isLoggedIn() {
		return loggedIn;
	}

	protected boolean testCon() {
		this.adddata();
		if (person.equals(null)) {
			return false;
		} else {
			return true;
		}
	}

	protected ArrayList<BinTermin> getAllTermsfrom(Calendar calendar) {
		ArrayList<BinTermin> listfrom = new ArrayList<>();
		listfrom = getAllTermsSorted();
		ArrayList<BinTermin> nextTerms = new ArrayList<>();
		for (int i = 0; i < listfrom.size(); i++) {
			if(listfrom.get(i).getConsultation().after(calendar)) {
				nextTerms.add(listfrom.get(i));
			}
		}
		return nextTerms;
	}
	protected ArrayList<BinTermin> getAllPastTerm(Calendar calendar) {
		ArrayList<BinTermin> listfrom = new ArrayList<>();
		listfrom = getAllTermsSorted();
		ArrayList<BinTermin> pastterm = new ArrayList<>();
		for (int i = 0; i < listfrom.size(); i++) {
			if(listfrom.get(i).getConsultation().before(calendar) || listfrom.get(i).isDone()) {
				pastterm.add(listfrom.get(i));
			}
		}
		return pastterm;
	}
	
	protected ArrayList<BinTermin> getAllMissedTerm(Calendar calendar) {
		ArrayList<BinTermin> listfrom = new ArrayList<>();
		listfrom = getAllTermsSorted();
		ArrayList<BinTermin> missedterm = new ArrayList<>();
		for (int i = 0; i < listfrom.size(); i++) {
			if(listfrom.get(i).getConsultation().before(calendar) && !listfrom.get(i).isDone()) {
				missedterm.add(listfrom.get(i));
			}
		}
		return missedterm;
	}

	public ArrayList<BinTermin> getAllTermsSorted() {
		Collections.sort(allTerms, new CalendarComparator());
		return allTerms;
	}
	
	public ArrayList<BinTermin> getAllTermRevertSorted(){
		ArrayList<BinTermin> ar = new ArrayList<BinTermin>(allTerms.size());
		int i = allTerms.size();
		for (BinTermin binTermin : allTerms) {
			ar.add(i, binTermin);
		}
		return ar;
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
			//UiPastList
		case "UiPastList":
			try {
				navigator.removeView(target);
			} finally {
				navigator.addView(target, new UiListPast(this));
			}
			break;
		case "":
			try {
				navigator.removeView(target);
			} finally {
				navigator.addView(target, new UiLogin(this));
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
