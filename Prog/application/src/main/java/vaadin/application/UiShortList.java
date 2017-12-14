package vaadin.application;

import java.util.ArrayList;

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
		nextterms = this.parent.getAllTermsfrom(DateL.now());
		VerticalLayout vl = new VerticalLayout();
		
		Accordion accordion = new Accordion();
		
		for(BinTermin term: nextterms) {
			VerticalLayout vla = new VerticalLayout();
			vla.addComponents(new Label(term.getMed().getTitle() +" " +term.getMed().getName() + " " + term.getMed().getFname()),
					new Label("tel: "+term.getMed().getTel()), new Label(""),
					new Label(term.getDescription()));
			accordion.addTab(vla,term.getConsultation().toStringSimple() + " " + term.getLenghofCons()+" s" + term.getEmplacement() );
		}
		
		
		Button back = new Button("Back");
		back.addClickListener(e -> {
			this.parent.navigateTo("");
		});
		Button previous = new Button("Past meetings");
		previous.addClickListener(e -> {
			this.parent.navigateTo("");
		});
		Button more = new Button("more");
		more.addClickListener(e -> {
			this.parent.navigateTo("");
		});
		HorizontalLayout hl = new HorizontalLayout();
		hl.addComponents(previous, back, more);
		//vl.addComponents(ter1, ter2, ter3);
		vl.addComponents(accordion,hl);
		vl.setComponentAlignment(accordion, Alignment.MIDDLE_CENTER);
		vl.setComponentAlignment(hl, Alignment.MIDDLE_CENTER);

		this.addComponent(vl);

	}

}
