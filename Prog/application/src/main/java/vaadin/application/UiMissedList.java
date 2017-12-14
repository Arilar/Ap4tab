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

public class UiMissedList extends VerticalLayout implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MyUI parent;
	private ArrayList<BinTermin> passtterms = new ArrayList<>();

	public UiMissedList(UI parent) {
		this.parent = (MyUI) parent;
		ArrayList<BinTermin> temp = this.parent.getAllMissedTerm(CalendarL.now());
		VerticalLayout vl = new VerticalLayout();

		Accordion accordion = new Accordion();

		for (BinTermin term : temp) {
			VerticalLayout vla = new VerticalLayout();
			vla.addComponents(
					new Label(
							term.getMed().getTitle() + " " + term.getMed().getName() + " " + term.getMed().getFname()),
					new Label("tel: " + term.getMed().getTel()), new Label(""), new Label(term.getDescription())
					);
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
		Button next = new Button("next meetings");
		next.addClickListener(e -> {
			this.parent.navigateTo("UiShortList");
		});
		Button previous = new Button("previous meetings");
		previous.addClickListener(e -> {
			this.parent.navigateTo("UiPastList");
		});
		HorizontalLayout hl = new HorizontalLayout();
		hl.addComponents(previous,next, back);
		vl.addComponents(accordion, hl);
		vl.setComponentAlignment(accordion, Alignment.MIDDLE_CENTER);
		vl.setComponentAlignment(hl, Alignment.MIDDLE_CENTER);

		this.addComponent(vl);

	}

}
