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
import com.vaadin.ui.Window;

/**
 * Is view for temporary purpose. 
 * @author burcusevinc
 *
 */
public class UiLogin extends VerticalLayout implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MyUI parent;

	public UiLogin(UI parent) {
		this.parent = (MyUI) parent;
		Label errorLogger = new Label();
		FormLayout form = new FormLayout();
		TextField tf1 = new TextField("Benutzername");
		tf1.setIcon(VaadinIcons.USER);
		form.addComponent(tf1);
		PasswordField pf1 = new PasswordField("Passwort");
		pf1.setIcon(VaadinIcons.KEY);
		form.addComponent(pf1);

		VerticalLayout vl = new VerticalLayout();
		HorizontalLayout formulaire = new HorizontalLayout();
		Button btCancel = new Button("Abbrechen", VaadinIcons.CLOSE_SMALL);
		Button btRegister = new Button("Registrieren");
		Button btLogin = new Button("Login");
		formulaire.addComponent(btLogin);
		formulaire.addComponent(btCancel);
		formulaire.addComponent(btRegister);

		btCancel.addClickListener(e -> {
			this.parent.navigateTo("");
		});
		btLogin.addClickListener(e -> {
			this.parent.login(tf1.getValue().toString(), pf1.getValue().toString());
			if(this.parent.isLoggedIn()) {
				this.parent.navigateTo("UiShortList");
			} else {
				errorLogger.setCaption("Wrong login or password");
			}
		});
		btRegister.addClickListener(e -> {
			this.parent.navigateTo("UiRegister");
		});
		vl.addComponent(errorLogger);
		vl.addComponent(form);
		vl.addComponent(formulaire);

		this.addComponent(vl);

	}

}
