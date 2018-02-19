package co.ceiba.parking.dominio;

public class Vehicle {
	
	private String tipo;
	private String placa;
	private String cilindraje;
	
	public Vehicle(String tipo, String placa, String cilindraje) {
		this.tipo = tipo;
		this.placa = placa;
		this.cilindraje = cilindraje;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(String cilindraje) {
		this.cilindraje = cilindraje;
	}
	

}
