package co.ceiba.parking.builder;

import co.ceiba.parking.Entity.VehicleEntity;
import co.ceiba.parking.dominio.Vehicle;

public class VehicleBuilder {

	public VehicleBuilder() {
	}

	public static Vehicle convertirADominio(VehicleEntity vehicleEntity) {
		Vehicle vehicle = null;
		if (vehicleEntity != null) {
			vehicle = new Vehicle(vehicleEntity.getTipo(), vehicleEntity.getPlaca(), vehicleEntity.getCilindraje());
		}
		return vehicle;
	}

}
