package co.ceiba.parking.persistence.repository;

import co.ceiba.parking.dominio.Vehicle;
import co.ceiba.parking.dominio.repositorio.VehicleRepository;
import co.ceiba.parking.persistence.builder.VehicleBuilder;
import co.ceiba.parking.persistence.entity.VehicleEntity;
import co.ceiba.parking.persistence.repository.jpa.VehicleRepositoryJPA;

public class VehicleRepositoryPersistence implements VehicleRepository {
	
	private VehicleRepositoryJPA vehicleRepositoryJPA;
	
	/**
	 * constructor
	 */
	public VehicleRepositoryPersistence() {
	}
	
	public Vehicle getByPlaque(String plaque) {
		VehicleEntity vehicleEntity = this.vehicleRepositoryJPA.findByPlaque(plaque);
		return VehicleBuilder.convertirADominio(vehicleEntity);
	}

}