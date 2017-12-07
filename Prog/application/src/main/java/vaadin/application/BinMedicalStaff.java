package vaadin.application;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * The class is for staff and intheritance class Person. 
 * @author burcusevinc
 *
 */

@Table(name = "MedicalStaff", schema="ap4tab")
public class BinMedicalStaff extends BinPerson {

	@Id
	private String EAN; // eanNumber
	
	private String institutionName; // Instiution name
	private String institutionAdresse; // street and number
	private int institutionPlz;
	private String institutionCity;
	
	public String getEAN() {
		return EAN;
	}

	public void setEAN(String eAN) {
		EAN = eAN;
	}

	public String getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

	public String getInstitutionAdresse() {
		return institutionAdresse;
	}

	public void setInstitutionAdresse(String institutionAdresse) {
		this.institutionAdresse = institutionAdresse;
	}

	public int getInstitutionPlz() {
		return institutionPlz;
	}

	public void setInstitutionPlz(int institutionPlz) {
		this.institutionPlz = institutionPlz;
	}

	public String getInstitutionCity() {
		return institutionCity;
	}

	public void setInstitutionCity(String institutionCity) {
		this.institutionCity = institutionCity;
	}

	public BinMedicalStaff(String login, String password, String title, String name, String fname, DateL birthdate, String email, String tel,
			String adresse, String city, int plz, String EAN, String institutionName, String institutionAdresse, int institutionPlz, String institutionCity ) {
		super(login, password, title, name, fname, birthdate, email, tel, adresse, city, plz, 2);
		this.EAN =EAN;
		this.institutionName = institutionName;
		this.institutionAdresse = institutionAdresse;
		this.institutionPlz = institutionPlz;
		this.institutionCity = institutionCity;
	}

	/**
	 * if (obj instanceof MountainBike) { MountainBike myBike = (MountainBike)obj; }
	 */

}
