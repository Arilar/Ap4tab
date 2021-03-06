package vaadin.application;

import javax.persistence.*;

@Table(name = "Type", schema="ap4tab")
public class BinType {
	@Id
	@GeneratedValue
	private long pk_type;
	private String rgb;
	private String name;
	private String status;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BinType(String rgb, String name, String status) {
		this.rgb = rgb;
		this.name = name;
		this.status = status;
	}

}
