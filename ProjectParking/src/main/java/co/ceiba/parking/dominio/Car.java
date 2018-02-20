package co.ceiba.parking.dominio;

public class Car extends Vehicle {
	
	public static final String TYPE = "CARRO";
	
	public Car(String plaque, String cylinder, String document) {
		super(TYPE, plaque, cylinder, document);
	}

}
