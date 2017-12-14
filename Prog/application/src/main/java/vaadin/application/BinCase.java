package vaadin.application;


import javax.persistence.*;

/**
 * The class is for assignment of case.
 * @author burcusevinc
 *
 */

@Table(name = "Case", schema="ap4tab")
public class BinCase {
	
	@Id
	@GeneratedValue
	private long caseId;
	
	private String caseName;
	private BinType caseType;
	private BinMedicalStaff respDr;
	private BinPatient patient;
	private DateL startCase;
	private DateL endCase;
	
	public long getCaseId() {
		return caseId;
	}
	public void setCaseId(long caseId) {
		this.caseId = caseId;
	}
	public String getCaseName() {
		return caseName;
	}
	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}
	public BinType getCaseType() {
		return caseType;
	}
	public void setCaseType(BinType caseType) {
		this.caseType = caseType;
	}
	public BinMedicalStaff getRespDr() {
		return respDr;
	}
	public void setRespDr(BinMedicalStaff respDr) {
		this.respDr = respDr;
	}
	public BinPatient getPatient() {
		return patient;
	}
	public void setPatient(BinPatient patient) {
		this.patient = patient;
	}
	public DateL getStartCase() {
		return startCase;
	}
	public void setStartCase(DateL startCase) {
		this.startCase = startCase;
	}
	public DateL getEndCase() {
		return endCase;
	}
	public void setEndCase(DateL endCase) {
		this.endCase = endCase;
	}

	
	public BinCase(String caseName, BinType caseType, BinMedicalStaff respDr, BinPatient patient,
			DateL startCase, DateL endCase) {
		super();
		this.caseName = caseName;
		this.caseType = caseType;
		this.respDr = respDr;
		this.patient = patient;
		this.startCase = startCase;
		this.endCase = endCase;
	}

	
	

}
