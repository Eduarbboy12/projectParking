package co.ceiba.parking.persistence.repository.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.ceiba.parking.persistence.entity.VehicleEntity;

@Repository
public interface VehicleRepositoryJPA extends CrudRepository<VehicleEntity, Long> {
	public VehicleEntity findByPlaque(String plaque);
	
	public VehicleEntity findByType(String type);
}
