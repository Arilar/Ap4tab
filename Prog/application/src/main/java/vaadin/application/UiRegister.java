package vaadin.application;


import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class UiRegister extends VerticalLayout implements View {

	/**
	 * 
	 */

	protected static final String UiRegister = "register";
	private static final long serialVersionUID = 1L;
	private MyUI parent;

	public UiRegister(UI parent) {
		this.parent = (MyUI) parent;
		FormLayout form = new FormLayout();
		
		Button btstatus = new Button("Ich bin ein Arzt", VaadinIcons.USER);
		form.addComponent(btstatus);
		
		TextField tf1 = new TextField("Benutzername");
		tf1.setRequiredIndicatorVisible(true);
		tf1.setIcon(VaadinIcons.USER);
		form.addComponent(tf1);
		
		PasswordField pf1 = new PasswordField("Password");
		pf1.setIcon(VaadinIcons.KEY);
		form.addComponent(pf1);
		
		PasswordField pf2 = new PasswordField("Confirm Password");
		pf2.setIcon(VaadinIcons.KEY);
		form.addComponent(pf2);
		TextField tf2 = new TextField("Name");
		tf2.setRequiredIndicatorVisible(true);
		tf2.setIcon(VaadinIcons.USER);
		form.addComponent(tf2);

		TextField tf3 = new TextField("Vorname");
		tf3.setRequiredIndicatorVisible(true);
		tf3.setIcon(VaadinIcons.USER);
		form.addComponent(tf3);

		TextField tf4 = new TextField("Adresse");
		tf4.setRequiredIndicatorVisible(true);
		tf4.setIcon(VaadinIcons.HOME_O);
		form.addComponent(tf4);

		TextField tf5 = new TextField("PLZ");
		tf5.setRequiredIndicatorVisible(true);
		tf5.setIcon(VaadinIcons.BUILDING_O);
		form.addComponent(tf5);

		TextField tf6 = new TextField("Stadt");
		tf6.setRequiredIndicatorVisible(true);
		tf6.setIcon(VaadinIcons.BUILDING_O);
		form.addComponent(tf6);

		TextField tf7 = new TextField("Telefon");
		tf7.setRequiredIndicatorVisible(true);
		tf7.setIcon(VaadinIcons.PHONE);
		form.addComponent(tf7);

		TextField tf8 = new TextField("E-Mail");
		tf8.setRequiredIndicatorVisible(true);
		tf8.setIcon(VaadinIcons.AT);
		form.addComponent(tf8);
		
		TextField tf9 = new TextField("AHV Nr.");
		tf8.setRequiredIndicatorVisible(true);
		//tf8.setIcon(VaadinIcons.AT);
		form.addComponent(tf9);
		
		TextField tf10 = new TextField("Versicherung");
		tf8.setRequiredIndicatorVisible(true);
		//tf8.setIcon(VaadinIcons.AT);
		form.addComponent(tf10);
		
		TextField tf11 = new TextField("Vers. Adresse");
		tf8.setRequiredIndicatorVisible(true);
		//tf8.setIcon(VaadinIcons.AT);
		form.addComponent(tf11);
		
		TextField tf12 = new TextField("Vers. Plz");
		tf8.setRequiredIndicatorVisible(true);
		//tf8.setIcon(VaadinIcons.AT);
		form.addComponent(tf12);
		
		TextField tf13 = new TextField("Vers. Stadt");
		tf8.setRequiredIndicatorVisible(true);
		//tf8.setIcon(VaadinIcons.AT);
		form.addComponent(tf13);
		
		TextField tf14 = new TextField("EAN / GLN");
		tf8.setRequiredIndicatorVisible(true);
		//tf8.setIcon(VaadinIcons.AT);
		
		btstatus.addClickListener(e -> {
			if (btstatus.getCaption().equals("Ich bin ein Arzt")) {
				btstatus.setCaption("Ich bin ein Patient");
				btstatus.setIcon(VaadinIcons.DOCTOR);
				form.removeComponent(tf9);
				form.removeComponent(tf10);
				form.removeComponent(tf11);
				form.removeComponent(tf12);
				form.removeComponent(tf13);
				form.addComponent(tf14);
				
			} else {
				btstatus.setCaption("Ich bin ein Arzt");
				btstatus.setIcon(VaadinIcons.USER);
				form.addComponents(tf9, tf10, tf11, tf12, tf13);
				form.removeComponent(tf14);
			}
		});

		VerticalLayout vl = new VerticalLayout();
		HorizontalLayout formulaire = new HorizontalLayout();
		Button btCancel = new Button("Abbrechen", VaadinIcons.CLOSE_SMALL);
		Button btLogin = new Button("Login");
		
		
		

		btCancel.addClickListener(e -> {
			this.parent.navigateTo("");
		});

		formulaire.addComponent(btLogin);
		formulaire.addComponent(btCancel);

		vl.addComponent(form);
		vl.addComponent(formulaire);

		this.addComponent(vl);
	}

}
