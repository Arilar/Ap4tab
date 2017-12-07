package vaadin.application;

import javax.persistence.Id;

/**
 * The class is for patient and intheritance class person. 
 * @author burcusevinc
 *
 */
public class BinPatient extends BinPerson {
	

	private String ahv; // format 756.7266.2047.88
	private String insuranceName; // organisation name
	private String insuranceAdress; // street and number
	private int insurancePlz;
	private String insuranceCity;

	@Id
	public String getAhv() {
		return ahv;
	}

	public void setAhv(String ahv) {
		this.ahv = ahv;
	}

	public String getInsuranceName() {
		return insuranceName;
	}

	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}

	public String getInsuranceAdress() {
		return insuranceAdress;
	}

	public void setInsuranceAdress(String insuranceAdress) {
		this.insuranceAdress = insuranceAdress;
	}

	public int getInsurancePlz() {
		return insurancePlz;
	}

	public void setInsurancePlz(int insurancePlz) {
		this.insurancePlz = insurancePlz;
	}

	public String getInsuranceCity() {
		return insuranceCity;
	}

	public void setInsuranceCity(String insuranceCity) {
		this.insuranceCity = insuranceCity;
	}

	public BinPatient(String login, String password, String title, String name, String fname, DateL birthdate, String email, String tel,
			String adresse, String city, int plz,String ahv, String insuranceName, String insuranceAdress, int insurancePlz,
			String insuranceCity) {
		super(login, password, title, name, fname, birthdate, email, tel, adresse, city, plz, 2);
		this.ahv = ahv;
		this.insuranceName = insuranceName;
		this.insuranceAdress = insuranceAdress;
		this.insurancePlz = insurancePlz;
		this.insuranceCity = insuranceCity;
	}
	
	
	

	/**
	 * if (obj instanceof MountainBike) { MountainBike myBike = (MountainBike)obj; }
	 */

}
