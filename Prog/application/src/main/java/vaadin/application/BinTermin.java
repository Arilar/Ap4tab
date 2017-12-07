package vaadin.application;


import javax.persistence.*;

@Table(name = "Termin", schema="ap4tab")
public class BinTermin{

	@Id
	@GeneratedValue
	private long pk_term;
	private BinMedicalStaff med;
	private BinType TerminCase;
	private BinCase caseID;
	private DateL consultation;
	private int lenghofCons; //in minuten
	private String description;
	private String emplacement;

	

	public BinTermin(BinMedicalStaff med, BinType terminCase, BinCase caseID, DateL consultation, int lenghofCons,
			String description, String emplacement) {
		this.caseID = caseID;
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
