package co.ceiba.parking.dominio;

public class Motorcycle extends Vehicle {

	public static final String TYPE = "MOTO";

	public Motorcycle(String plaque, String cylinder, String document) {
		super(TYPE, plaque, cylinder, document);
	}

}
