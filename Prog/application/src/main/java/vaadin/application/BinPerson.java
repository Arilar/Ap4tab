package vaadin.application;


public class BinPerson {

	private String login;
	private String password;
	private String title;
	private String name;
	private String fname;
	//private Date dateNaiss;  
	private String email;
	private String tel;
	private String adresse;
	private String city;
	private int plz;
	private int persType; //1=patient 2=medicalStaff
	
	
	
	public BinPerson(String login, String password, String title, String name, String fname, String email, String tel,
			String adresse, String city, int plz, int persType) {
		
		this.login = login;
		this.password = password;
		this.title = title;
		this.name = name;
		this.fname = fname;
		this.email = email;
		this.tel = tel;
		this.adresse = adresse;
		this.city = city;
		this.plz = plz;
		this.persType = persType;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPlz() {
		return plz;
	}
	public void setPlz(int plz) {
		this.plz = plz;
	}
	public int getPersType() {
		return persType;
	}
	public void setPersType(int persType) {
		this.persType = persType;
	}
	
	
	
	

}