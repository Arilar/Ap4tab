package vaadin.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BinTermin{

	private BinMedicalStaff med;
	private BinType TerminCase;
	private BinPatient patient;
	private DateL consultation;
	private int lenghofCons; //in minuten
	private String description;
	private String emplacement;

	public BinPatient getPatient() {
		return patient;
	}

	public void setPatient(BinPatient patient) {
		this.patient = patient;
	}

	public BinMedicalStaff getMed() {
		return med;
	}

	public void setMed(BinMedicalStaff med) {
		this.med = med;
	}

	public BinType getTerminCase() {
		return TerminCase;
	}

	public void setTerminCase(BinType terminCase) {
		TerminCase = terminCase;
	}

	public DateL getConsultation() {
		return consultation;
	}

	public void setConsultation(DateL consultation) {
		this.consultation = consultation;
	}

	public int getLenghofCons() {
		return lenghofCons;
	}

	public void setLenghofCons(int lenghofCons) {
		this.lenghofCons = lenghofCons;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmplacement() {
		return emplacement;
	}

	public void setEmplacement(String emplacement) {
		this.emplacement = emplacement;
	}

	public BinTermin(BinMedicalStaff med, BinType terminCase, BinPatient patient, DateL consultation, int lenghofCons,
			String description, String emplacement) {
		this.patient = patient;
		this.med = med;
		TerminCase = terminCase;
		this.consultation = consultation;
		this.lenghofCons = lenghofCons;
		this.description = description;
		this.emplacement = emplacement;
	}

	@Override
	public String toString() {
		return consultation.toString() + " " + emplacement;
	}

	

}
