package co.ceiba.parking.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity(name = "Invoice")
@NamedQuery(name = "Invoice.findById", query = "SELECT i FROM Invoice i WHERE i.id = :id")
public class InvoiceEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	@JoinColumn(name="ID_VEHICLE",referencedColumnName="id")
	private VehicleEntity vehicle;
	
	@Column(name = "ingreso")
	private Date ingreso;
	
	@Column(name = "salida")
	private Date salida;
	
	@Column(name = "valortotal")
	private Double valortotal;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public VehicleEntity getVehicle() {
		return vehicle;
	}

	public void setVehicle(VehicleEntity vehicle) {
		this.vehicle = vehicle;
	}

	public Date getIngreso() {
		return ingreso;
	}

	public void setIngreso(Date ingreso) {
		this.ingreso = ingreso;
	}

	public Date getSalida() {
		return salida;
	}

	public void setSalida(Date salida) {
		this.salida = salida;
	}

	public Double getValortotal() {
		return valortotal;
	}

	public void setValortotal(Double valortotal) {
		this.valortotal = valortotal;
	}
	
	

}
