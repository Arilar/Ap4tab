package vaadin.application;


import java.util.Calendar;

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
	private Calendar startCase = Calendar.getInstance();
	private Calendar endCase = Calendar.getInstance();
	
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
	public Calendar getStartCase() {
		return startCase;
	}
	public void setStartCase(Calendar startCase) {
		this.startCase = startCase;
	}
	public Calendar getEndCase() {
		return endCase;
	}
	public void setEndCase(Calendar endCase) {
		this.endCase = endCase;
	}

	
	public BinCase(String caseName, BinType caseType, BinMedicalStaff respDr, BinPatient patient,
			Calendar startCase, Calendar endCase) {
		super();
		this.caseName = caseName;
		this.caseType = caseType;
		this.respDr = respDr;
		this.patient = patient;
		this.startCase = startCase;
		this.endCase = endCase;
	}

	
	

}
