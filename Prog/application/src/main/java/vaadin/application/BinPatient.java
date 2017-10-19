package vaadin.application;

public class BinPatient extends BinPerson {

	private String ahv; // format 756.7266.2047.88
	private String insuranceName; // organisation name
	private String insuranceAdress; // street and number
	private int insurancePlz;
	private String insuranceCity;

	/*public String getName() {
		return super.getName();
	}

	public void setFName(String fname) {
		super.setFname(fname);
		;
	}

	public String getFName() {
		return super.getFname();
	}

	public String getTitle() {
		return super.getTitle();
	}

	public void setTitle(String title) {
		super.setTitle(title);
	}

	public String getLogin() {
		return super.getLogin();
	}

	public void SetLogin(String login) {
		super.setLogin(login);
	}

	public String getPassword() {
		return super.getPassword();
	}

	public void setPassword(String password) {
		super.setPassword(password);
	}

	public String getEmail() {
		return super.getEmail();
	}

	public void setEmail(String email) {
		super.setEmail(email);
	}
	public String getTel() {
		return super.getTel();
	}
	
	public void setTel(String tel) {
		super.setTel(tel);
	}
	public String getAdresse() {
		return this.getAdresse();
	}
	
	public void setAdresse(String adresse) {
		super.setAdresse(adresse);
	}
	public String getCity() {
		return super.getCity();
	}
	
	public void setCity(String city) {
		super.setCity(city);
	}
	
	public int getPlz() {
		return super.getPlz();
	}
	
	public void setPlz(int plz) {
		super.setPlz(plz);
	}
	
	public int getPersType() {
		return this.getPersType();
	}*/
	
	
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

	public BinPatient(String login, String password, String title, String name, String fname, String email, String tel,
			String adresse, String city, int plz,String ahv, String insuranceName, String insuranceAdress, int insurancePlz,
			String insuranceCity) {
		super(login, password, title, name, fname, email, tel, adresse, city, plz, 2);
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
