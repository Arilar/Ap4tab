package vaadin.application;

import java.util.Comparator;

public class TerminComparatorDate implements Comparator<BinTermin> {

	
//	@Override
//	public int compareTo(BinTermin other) {
//		long l1 = consultation.getTime();
//	    long l2 = other.getConsultation().getTime();
//	    if (l2 > l1)
//	    return 1;
//	    else if (l1 > l2)
//	    return -1;
//	    else
//	    return 0;
//	}

	@Override
	public int compare(BinTermin o1, BinTermin o2) {
		if(o1.getConsultation().getTime() > o2.getConsultation().getTime()) {
			return 1;
		}
		else if(o1.getConsultation().getTime() < o2.getConsultation().getTime()) {
			return -1;
		} else {
			return 0;
		}
	}
}
