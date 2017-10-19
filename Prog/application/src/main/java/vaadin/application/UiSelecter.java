package vaadin.application;

import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class UiSelecter extends VerticalLayout implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MyUI parent;
	public UiSelecter(UI parent) {
		this.parent = (MyUI) parent;
		
		Button login = new Button("login View");
		Button register = new Button("Register View");
		Button patient = new Button("Patient View");
		

		login.addClickListener(e -> {this.parent.navigateTo("UiLogin");});
		register.addClickListener(e -> {this.parent.navigateTo("UiRegister");});
		patient.addClickListener(e -> {this.parent.navigateTo("UiPatient");});
		
		this.addComponents(login, register, patient);
		
		// TODO Auto-generated constructor stub
	}

	
}
