package vaadin.application;

import java.util.ArrayList;
import java.util.Calendar;

import com.vaadin.navigator.View;
import com.vaadin.ui.Accordion;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class UiListPast extends VerticalLayout implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MyUI parent;
	private ArrayList<BinTermin> passtterms = new ArrayList<>();

	public UiListPast(UI parent) {
		this.parent = (MyUI) parent;
		ArrayList<BinTermin> temp = this.parent.getAllPastTerm(CalendarL.now());
		VerticalLayout vl = new VerticalLayout();
		Label bal = new Label("Vergangene Termine");
		bal.addStyleName( "h1" );
		vl.addComponent(bal);
		vl.setComponentAlignment(bal, Alignment.MIDDLE_CENTER);
		Accordion accordion = new Accordion();

		for (BinTermin term : temp) {
			VerticalLayout vla = new VerticalLayout();
			Button button = new Button("Nicht gemacht");
			button.addClickListener(e -> {
				if (term.isDone()) {
					term.setDone(false);
					button.setCaption("Gemacht");
					this.parent.navigateTo("UiPastList");
				} else {
					term.setDone(false);
					button.setCaption("Gemacht");
					this.parent.navigateTo("UiPastList");
				}
			});
			if(term.getConsultation().after(Calendar.getInstance().getTime())) { 
			vla.addComponents(
					new Label(
							term.getMed().getTitle() + " " + term.getMed().getName() + " " + term.getMed().getFname()),
					new Label("Tel: " + term.getMed().getTel()), new Label(""), new Label(term.getDescription()),
					new Label(""), button);
			} else {
				vla.addComponents(
						new Label(
								term.getMed().getTitle() + " " + term.getMed().getName() + " " + term.getMed().getFname()),
						new Label("Tel: " + term.getMed().getTel()), new Label(""), new Label(term.getDescription()),
						new Label(""));
			}
			Calendar cae = (Calendar) term.getConsultation().clone();
			cae.add(Calendar.MINUTE, term.getLenghofCons());
			accordion.addTab(vla, CalendarL.getAD(term.getConsultation()) + " - "
					+ CalendarL.getMD(cae)
					+ " " + term.getEmplacement());
		}
		accordion.setSelectedTab(accordion.getComponentCount()-1);

		Button back = new Button("Abmelden");
		back.addClickListener(e -> {
			this.parent.navigateTo("");
		});
		Button next = new Button("Nächste Termine");
		next.addClickListener(e -> {
			this.parent.navigateTo("UiShortList");
		});
		
		HorizontalLayout hl = new HorizontalLayout();
		hl.addComponents(next, back);
		vl.addComponents(accordion, hl);
		vl.setComponentAlignment(accordion, Alignment.MIDDLE_CENTER);
		vl.setComponentAlignment(hl, Alignment.MIDDLE_CENTER);

		this.addComponent(vl);

	}

}
