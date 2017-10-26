package vaadin.application;

public class BinType {

	private String rgb;
	private String name;
	
	public String getRgb() {
		return rgb;
	}
	public void setRgb(String rgb) {
		this.rgb = rgb;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BinType(String rgb, String name) {
		this.rgb = rgb;
		this.name = name;
	}
	
	
}
