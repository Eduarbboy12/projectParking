package co.ceiba.parking.dominio;

import java.util.Date;

import co.ceiba.parking.persistence.entity.VehicleEntity;

public class Invoice {

	private VehicleEntity vehicle;
	private Date ingreso;
	private Date salida;
	private double valortotal;
	
	public Invoice(VehicleEntity vehicle, Date ingreso, Date salida, double valortotal) {
		this.vehicle = vehicle;
		this.ingreso = ingreso;
		this.salida = salida;
		this.valortotal = valortotal;
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

	public double getValortotal() {
		return valortotal;
	}

	public void setValortotal(double valortotal) {
		this.valortotal = valortotal;
	}
	
}
