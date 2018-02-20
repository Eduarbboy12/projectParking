package co.ceiba.parking.persistence.repository;

import javax.persistence.EntityManager;

import co.ceiba.parking.dominio.Vehicle;
import co.ceiba.parking.dominio.repositorio.VehicleRepository;
import co.ceiba.parking.persistence.builder.VehicleBuilder;
import co.ceiba.parking.persistence.entity.VehicleEntity;
import co.ceiba.parking.persistence.repository.jpa.VehicleRepositoryJPA;

public class VehicleRepositoryPersistence implements VehicleRepository {
	
	private EntityManager entityManager;
	private VehicleRepositoryJPA vehicleRepositoryJPA;
	
	public VehicleRepositoryPersistence(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public Vehicle getByPlaque(String plaque) {
		VehicleEntity vehicleEntity = vehicleRepositoryJPA.findByPlaque(plaque);
		return VehicleBuilder.convertirADominio(vehicleEntity);
	}
	
	public void saveVehicle(Vehicle vehicle) {
		
	}

}
