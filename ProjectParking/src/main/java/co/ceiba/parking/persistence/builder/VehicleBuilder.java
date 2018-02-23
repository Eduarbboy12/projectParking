package co.ceiba.parking.persistence.builder;

import co.ceiba.parking.dominio.Vehicle;
import co.ceiba.parking.persistence.entity.VehicleEntity;

public class VehicleBuilder {

	/**
	 * Contructor
	 */
	public VehicleBuilder() {
		// Do nothing because is a constructor.
	}

	public static Vehicle convertirADominio(VehicleEntity vehicleEntity) {
		Vehicle vehicle = null;
		if (vehicleEntity != null) {
			vehicle = new Vehicle(vehicleEntity.getType(), vehicleEntity.getPlaque(), vehicleEntity.getCylinder(), vehicleEntity.getDocument());
		}
		return vehicle;
	}

	public static VehicleEntity convertirAEntity(Vehicle vehicle) {
		VehicleEntity vehicleEntity = new VehicleEntity();
		vehicleEntity.setCylinder(vehicle.getCylinder());
		vehicleEntity.setPlaque(vehicle.getPlaque());
		vehicleEntity.setType(vehicle.getType());
		vehicleEntity.setDocument(vehicle.getDocument());
		return vehicleEntity;
	}

}
