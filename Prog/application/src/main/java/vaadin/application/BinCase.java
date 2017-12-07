package vaadin.application;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

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
	private String caseType;
	private BinMedicalStaff respDr;
	private BinPatient patient;
	private Date startCase;
	private Date endCase;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
	private HashMap<Date, BinTermin> relatedTermins;
	
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
	public String getCaseType() {
		return caseType;
	}
	public void setCaseType(String caseType) {
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
	public Date getStartCase() {
		return startCase;
	}
	public void setStartCase(Date startCase) {
		this.startCase = startCase;
	}
	public Date getEndCase() {
		return endCase;
	}
	public void setEndCase(Date endCase) {
		this.endCase = endCase;
	}
	public SimpleDateFormat getSdf() {
		return sdf;
	}
	public void setSdf(SimpleDateFormat sdf) {
		this.sdf = sdf;
	}
	
	public BinCase(String caseName, String caseType, BinMedicalStaff respDr, BinPatient patient,
			Date startCase, Date endCase, SimpleDateFormat sdf) {
		super();
		this.caseName = caseName;
		this.caseType = caseType;
		this.respDr = respDr;
		this.patient = patient;
		this.startCase = startCase;
		this.endCase = endCase;
		this.sdf = sdf;
	}

	
	

}
