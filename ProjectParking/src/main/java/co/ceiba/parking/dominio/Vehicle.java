package co.ceiba.parking.dominio;

public class Vehicle {
	
	private String type;
	private String plaque;
	private String cylinder;
	private String document;
	
	public Vehicle(String type, String plaque, String cylinder, String document) {
		this.type = type;
		this.plaque = plaque;
		this.cylinder = cylinder;
		this.document = document;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPlaque() {
		return plaque;
	}

	public void setPlaque(String plaque) {
		this.plaque = plaque;
	}

	public String getCylinder() {
		return cylinder;
	}

	public void setCylinder(String cylinder) {
		this.cylinder = cylinder;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}
	

}
