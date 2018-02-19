package co.ceiba.parking.dominio;

public class Car extends Vehicle {
	
	public static final String TIPO = "CARRO";
	
	public Car(String placa, String cilindraje) {
		super(TIPO, placa, cilindraje);
	}

}
