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
	
	public Vehicle getByPlaca(String placa) {
		VehicleEntity vehicleEntity =  vehicleRepositoryJPA.findByPlaca(placa);
		return VehicleBuilder.convertirADominio(vehicleEntity);
	}
	
	public void saveVehiculo(Vehicle vehicle) {
		
	}

}
