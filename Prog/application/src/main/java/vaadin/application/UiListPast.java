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
			vla.addComponents(
					new Label(
							term.getMed().getTitle() + " " + term.getMed().getName() + " " + term.getMed().getFname()),
					new Label("tel: " + term.getMed().getTel()), new Label(""), new Label(term.getDescription()),
					new Label(""), button);
			Calendar cae = (Calendar) term.getConsultation().clone();
			cae.add(Calendar.MINUTE, term.getLenghofCons());
			accordion.addTab(vla, CalendarL.getAD(term.getConsultation()) + " - "
					+ CalendarL.getMD(cae)
					+ " " + term.getEmplacement());
		}

		Button back = new Button("Back");
		back.addClickListener(e -> {
			this.parent.navigateTo("");
		});
		Button previous = new Button("next meetings");
		previous.addClickListener(e -> {
			this.parent.navigateTo("UiShortList");
		});
		Button missed = new Button("missed meetings");
		previous.addClickListener(e -> {
			this.parent.navigateTo("UiMissedList");
		});
		HorizontalLayout hl = new HorizontalLayout();
		hl.addComponents(previous,missed, back);
		vl.addComponents(accordion, hl);
		vl.setComponentAlignment(accordion, Alignment.MIDDLE_CENTER);
		vl.setComponentAlignment(hl, Alignment.MIDDLE_CENTER);

		this.addComponent(vl);

	}

}
