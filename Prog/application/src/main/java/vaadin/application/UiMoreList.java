package vaadin.application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class UiMoreList extends VerticalLayout implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MyUI parent;
	private ArrayList<BinTermin> allTermsNext;

	public UiMoreList(UI parent) {
		this.parent = (MyUI) parent;
		VerticalLayout vl = new VerticalLayout();
		int term = 0;
		sortedALNext();
		//TODO sort all item from list
		/**
		for (BinTermin termin : this.parent.getAllTerms()) {
			
		}
		**/
		Button back = new Button("Back");
		back.addClickListener(e -> {
			this.parent.navigateTo("UiShortList");
		});
		vl.addComponent(back);

		this.addComponent(vl);

	}
	
	private ArrayList<BinTermin> sortedALNext(){
		allTermsNext = parent.getAllTerms();
		Collections.sort(allTermsNext, new Comparator<BinTermin>() {
			@Override
			public int compare(BinTermin t1, BinTermin t2) {
				return t1.getConsultation().compareTo(t2.getConsultation());
			}
	    });
		return null;
	}

	private BinTermin getTerminTimed(int nb) {
		return allTermsNext.get(nb);
	}

}
