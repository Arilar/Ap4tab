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
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class UIShortList extends VerticalLayout implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MyUI parent;

	public UIShortList(UI parent) {
		this.parent = (MyUI) parent;

		VerticalLayout vl = new VerticalLayout();

		Button ter1 = new Button(getTerminTimed(0).toString());
		Button ter2 = new Button(getTerminTimed(1).toString());
		Button ter3 = new Button(getTerminTimed(2).toString());
		Button back = new Button("Back");
		back.addClickListener(e -> {
			this.parent.navigateTo("");
		});
		vl.addComponents(ter1, ter2, ter3, back);

		this.addComponent(vl);

	}

	private BinTermin getTerminTimed(int nb) {
		return parent.getAllTerms().get(nb);
	}

}
