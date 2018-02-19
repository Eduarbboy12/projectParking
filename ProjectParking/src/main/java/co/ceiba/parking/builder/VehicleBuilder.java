package co.ceiba.parking.builder;

import co.ceiba.parking.Entity.VehicleEntity;
import co.ceiba.parking.dominio.Vehicle;


public class VehicleBuilder {
	
	public VehicleBuilder() {}
	
	public static Vehicle convertirADominio(VehicleEntity vehicle) {
		Vehicle v = null;
		if(vehicle != null) {
			v = new Vehicle(vehicle.getTipo(), vehicle.getPlaca(), vehicle.getCilindraje());
		}
		return v;
	}

}
