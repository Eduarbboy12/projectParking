package co.ceiba.parking.dominio;

public class Motorcycle extends Vehicle {

	public static final String TIPO = "MOTO";

	public Motorcycle(String placa, String cilindraje) {
		super(TIPO, placa, cilindraje);
	}

}
