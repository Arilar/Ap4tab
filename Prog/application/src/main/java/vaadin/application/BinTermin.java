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

	
	
	
	
	




	/**
	 * @return the med
	 */
	public BinMedicalStaff getMed() {
		return med;
	}





	/**
	 * @param med the med to set
	 */
	public void setMed(BinMedicalStaff med) {
		this.med = med;
	}





	/**
	 * @return the terminCase
	 */
	public BinType getTerminCase() {
		return TerminCase;
	}





	/**
	 * @param terminCase the terminCase to set
	 */
	public void setTerminCase(BinType terminCase) {
		TerminCase = terminCase;
	}





	/**
	 * @return the caseID
	 */
	public BinCase getCaseID() {
		return caseID;
	}





	/**
	 * @param caseID the caseID to set
	 */
	public void setCaseID(BinCase caseID) {
		this.caseID = caseID;
	}





	/**
	 * @return the consultation
	 */
	public DateL getConsultation() {
		return consultation;
	}





	/**
	 * @param consultation the consultation to set
	 */
	public void setConsultation(DateL consultation) {
		this.consultation = consultation;
	}





	/**
	 * @return the lenghofCons
	 */
	public int getLenghofCons() {
		return lenghofCons;
	}





	/**
	 * @param lenghofCons the lenghofCons to set
	 */
	public void setLenghofCons(int lenghofCons) {
		this.lenghofCons = lenghofCons;
	}





	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}





	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}





	/**
	 * @return the emplacement
	 */
	public String getEmplacement() {
		return emplacement;
	}





	/**
	 * @param emplacement the emplacement to set
	 */
	public void setEmplacement(String emplacement) {
		this.emplacement = emplacement;
	}





	@Override
	public String toString() {
		return consultation.toString() + " " + emplacement;
	}


	

}
