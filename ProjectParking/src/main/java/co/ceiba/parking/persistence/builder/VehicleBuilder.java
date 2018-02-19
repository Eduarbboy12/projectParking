package co.ceiba.parking.persistence.builder;

import co.ceiba.parking.dominio.Vehicle;
import co.ceiba.parking.persistence.entity.VehicleEntity;

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
	
	public static VehicleEntity convertirAEntity(Vehicle vehicle) {
		VehicleEntity vehicleEntity = new VehicleEntity();
		vehicleEntity.setCilindraje(vehicle.getCilindraje());
		vehicleEntity.setPlaca(vehicle.getPlaca());
		vehicleEntity.setTipo(vehicle.getTipo());
		return vehicleEntity;
	}

}
