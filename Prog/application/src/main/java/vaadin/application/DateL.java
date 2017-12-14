package vaadin.application;

import java.sql.Timestamp;

public class DateL extends Timestamp{


	@SuppressWarnings("deprecation")
	public DateL(int year, int month, int day, Integer hour, int minute) {
		super(year, month, day, hour, minute, 00, 00);
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.minute = minute;
		this.second = 00;
		this.milisec = 000;
		
	}
	
	@SuppressWarnings("deprecation")
	public DateL(int year, int month, int day) {
		super(year, month, day, 00, 00, 00, 00);
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = 00;
		this.minute = 00;
		this.second = 00;
		this.milisec = 000;
	}
	
	@SuppressWarnings("deprecation")
	public Timestamp getTimeStamp() {
		return new Timestamp(year, month, day, hour, minute, second, milisec);
	}
	
	
	public DateL(long time) {
		super(time);
		this.day = 31;
		this.month = 12;
		this.year = 3333;
		this.hour = 00;
		this.minute = 00;
		this.second = 00;
		this.milisec = 000;
	}



	private static final long serialVersionUID = 1L;
	private int day;
	private int month;
	private int year;
	private int hour; 
	private int minute;
	private Integer second;
	private Integer milisec;
	
	public static Timestamp now() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return timestamp;
	}
	
	public void setDay(int day) {
		this.day = day;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	
	public void setMinute(int minute) {
		this.minute = minute;
	}
	
	

	

	@Override
	public String toString() {
		return year +"-" + month + "-" + day + " " +hour + ":" + minute + ":00.000";
	}

	public String toStringSimple() {
		return day +"/" + month + "/" + year;
	}
	
	
	
	
	
}
