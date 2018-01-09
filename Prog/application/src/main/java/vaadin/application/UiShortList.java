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

public class UiShortList extends VerticalLayout implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MyUI parent;
	private ArrayList<BinTermin> nextterms = new ArrayList<>();

	public UiShortList(UI parent) {
		this.parent = (MyUI) parent;
		ArrayList<BinTermin> temp = this.parent.getAllTermsfrom(CalendarL.now());
		for (BinTermin term : temp) {
			if (!term.isDone())
				nextterms.add(term);
		}
		VerticalLayout vl = new VerticalLayout();

		Accordion accordion = new Accordion();

		for (BinTermin term : nextterms) {
			VerticalLayout vla = new VerticalLayout();
			Button button = new Button("Gemacht");
			button.addClickListener(e -> {
				if (!term.isDone()) {
					term.setDone(true);
					button.setCaption("Nicht gemacht");
					this.parent.navigateTo("UiShortList");
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
		Button previous = new Button("Past meetings");
		previous.addClickListener(e -> {
			this.parent.navigateTo("UiPastList");
		}); 
		Button missed = new Button("Missed meetings");
		missed.addClickListener(e -> {
			this.parent.navigateTo("UiMissedList");
		});
		HorizontalLayout hl = new HorizontalLayout();
		hl.addComponents(previous, missed, back);
		vl.addComponents(accordion, hl);
		vl.setComponentAlignment(accordion, Alignment.MIDDLE_CENTER);
		vl.setComponentAlignment(hl, Alignment.MIDDLE_CENTER);

		this.addComponent(vl);

	}

}
