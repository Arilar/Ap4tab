package vaadin.application;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.UserError;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class UiLogin extends VerticalLayout{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UiLogin() {
		HorizontalLayout centerH = new HorizontalLayout();
		
		FormLayout form = new FormLayout();
		TextField tf1 = new TextField("Benutzername");
		tf1.setIcon(VaadinIcons.USER);
		tf1.setRequiredIndicatorVisible(true);
		form.addComponent(tf1);
		PasswordField pf1 = new PasswordField();
		pf1.setIcon(VaadinIcons.KEY);
		form.addComponent(pf1);
		
		VerticalLayout vl = new VerticalLayout();
		HorizontalLayout formulaire = new HorizontalLayout();
		Button btCancel = new Button("Abbrechen", VaadinIcons.CLOSE_SMALL);
		Button btLogin = new Button("Login", VaadinIcons.)
		vl.addComponent(form);
		
	}




}
