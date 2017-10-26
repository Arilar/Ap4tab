package vaadin.application;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class UiPatient extends VerticalLayout implements View {

	protected static final String PATIENT = "PATIENT";
	private MyUI parent;
	private BinPatient patient;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UiPatient(UI parent) {
		this.parent = (MyUI) parent;
		if (this.parent.testCon() == true) {
			if (this.parent.getPerson() instanceof BinPatient) {
				patient = (BinPatient) this.parent.getPerson();
				GridLayout grid = new GridLayout(2, 15);
				grid.addComponent(new Label("Name :"), 0, 0);
				grid.addComponent(new Label(patient.getName()), 1, 0);
				grid.addComponent(new Label("Vorname :"), 0, 1);
				grid.addComponent(new Label(patient.getFname()), 1, 1);
				grid.addComponent(new Label("Geburtsdatum :"), 0, 2);
				grid.addComponent(new Label(""), 1, 2); //TOADD
				grid.addComponent(new Label("Adresse :"), 0, 3);
				grid.addComponent(new Label(patient.getAdresse()), 1, 3);
				grid.addComponent(new Label("Stadt :"), 0, 4);
				grid.addComponent(new Label(patient.getPlz() + " " + patient.getCity() ), 1, 4);
				grid.addComponent(new Label(), 0, 5);
				grid.addComponent(new Label(), 1, 5);
				grid.addComponent(new Label("AHV Nr :"), 0, 6);
				grid.addComponent(new Label(patient.getAhv()), 1, 6);
				grid.addComponent(new Label("Versicherung :"), 0, 7);
				grid.addComponent(new Label(patient.getInsuranceName()), 1, 7);
				grid.addComponent(new Label("Vers. Adresse :"), 0, 8);
				grid.addComponent(new Label(patient.getInsuranceAdress()), 1, 8);
				grid.addComponent(new Label("Vers. Stadt :"), 0, 9);
				grid.addComponent(new Label(patient.getInsurancePlz() + " " + patient.getInsuranceCity()), 1, 9);
				
				this.addComponent(grid);
				
				Button btback = new Button("zurück", VaadinIcons.BACKSPACE_A);
				btback.addClickListener(e -> {
					this.parent.navigateTo("");
				});
				this.addComponent(btback);
			}

		}

	}

}
