package vaadin.application;

import java.util.Calendar;
import java.util.Date;

public class CalendarL{

	
	
	public static Calendar now() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date(System.currentTimeMillis()));
		return c;
	}
	
	public static Calendar setCalendarYMA(int year, int month, int day) {
	    Calendar c = Calendar.getInstance();
	    c.set(Calendar.YEAR, year);
	    c.set(Calendar.DATE, month-1);
	    c.set(Calendar.DAY_OF_MONTH, day);
	    return c;
	}
	public static Calendar setCalendarYMAHM(int year, int month, int day, int hour, int minut) {
	    Calendar c = Calendar.getInstance();
	   // c.setLenient(false);
	    c.set(Calendar.YEAR, year);
	    c.set(Calendar.MONTH, month-1);
	    c.set(Calendar.DATE, day);
	    c.set(Calendar.HOUR_OF_DAY, day);
	    c.set(Calendar.MINUTE, day);
	    return c;
	}
	
	public static String getSD(Calendar cal) {
		String ret = new String();
		ret = cal.get(Calendar.DAY_OF_MONTH) + "-" +(cal.get(Calendar.MONTH)+1)+ "-" + cal.get(Calendar.YEAR) ;
		return ret;
	}
	
	public static String getAD(Calendar cal) {
		String ret = new String();
		ret = cal.get(Calendar.DAY_OF_MONTH) + "-" +(cal.get(Calendar.MONTH)+1)+ "-" + cal.get(Calendar.YEAR)+ " "+  cal.get(Calendar.HOUR)+"h"+cal.get(Calendar.MINUTE);
		return ret;
	}
	
	public static String getMD(Calendar cal) {
		String ret = new String();
		ret =  cal.get(Calendar.HOUR)+"h"+cal.get(Calendar.MINUTE);
		return ret;
	}


}
