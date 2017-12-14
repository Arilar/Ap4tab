package vaadin.application;

import java.util.Calendar;
import java.util.Comparator;

public class CalendarComparator implements Comparator {

	public int compare(Object x, Object y) {
		BinTermin bx = (BinTermin) x;
		BinTermin by = (BinTermin) y;
		Calendar xcal = bx.getConsultation();
		Calendar ycal = by.getConsultation();
		if (xcal.before(ycal))
			return -1;
		if (xcal.after(ycal))
			return 1;
		return 0;
	}

	public static final Comparator INSTANCE = new CalendarComparator();

}
