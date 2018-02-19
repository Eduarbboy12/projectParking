package co.ceiba.parking.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "RegisterVehicleEntity")
public class RegisterVehicleEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	@JoinColumn(name="vehicle",referencedColumnName="id")
	private VehicleEntity vehicle;
	
	@Column(name = "salida")
	private int cantidadVehiculoOcupado;

}
