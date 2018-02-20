package co.ceiba.parking.testdatabuilder;

import co.ceiba.parking.dominio.Vehicle;

public class VehicleTestDataBuilder {
	
	private static final String TYPE = "CARRO";
	private static final String PLAQUE = "ABC123";
	private static final String CYLINDER = "200";
	private static final String DOCUMENT = "1102360555";
	
	private String type;
	private String plaque;
	private String cylinder;
	private String document;
	
	public VehicleTestDataBuilder() {
		this.type = TYPE;
		this.plaque = PLAQUE;
		this.cylinder = CYLINDER;
		this.document = DOCUMENT;
	}
	
	public VehicleTestDataBuilder conType(String type) {
		this.type = type;
		return this;
	}
	
	public VehicleTestDataBuilder conPlaque(String plaque) {
		this.plaque = plaque;
		return this;
	}
	
	public VehicleTestDataBuilder conCylinder(String cylinder) {
		this.cylinder = cylinder;
		return this;
	}
	
	public VehicleTestDataBuilder conDocument(String document) {
		this.document = document;
		return this;
	}
	
	public Vehicle build() {
		return new Vehicle(this.type, this.plaque, this.cylinder, this.document);
	}
		
		
	

}
