package co.ceiba.parking.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity(name = "Vehicle")
@NamedQuery(name = "Vehicle.findById", query = "SELECT v FROM Vehicle v WHERE v.id = :id")
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name = "tipo", nullable = false)
	private String tipo;
	
	@Column(name = "placa")
    private String placa;
	
	@Column(name = "cilindraje")
    private String cilindraje;
	
	public Vehicle(Long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
