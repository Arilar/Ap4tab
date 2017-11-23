package vaadin.application;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class UiShortList extends VerticalLayout implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MyUI parent;

	public UiShortList(UI parent) {
		this.parent = (MyUI) parent;

		VerticalLayout vl = new VerticalLayout();
		
		
		Button ter1 = new Button(getTerminTimed(0).toString());
		ter1.setWidth(100, UNITS_PERCENTAGE);
		Button ter2 = new Button(getTerminTimed(1).toString());
		ter2.setWidth(100, UNITS_PERCENTAGE);
		Button ter3 = new Button(getTerminTimed(2).toString());
		ter3.setWidth(100, UNITS_PERCENTAGE);
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
		hl.addComponents(previous, more);
		vl.addComponents(ter1, ter2, ter3, back);

		this.addComponent(vl);

	}

	private BinTermin getTerminTimed(int nb) {
		return parent.getAllTerms().get(nb);
	}

}
