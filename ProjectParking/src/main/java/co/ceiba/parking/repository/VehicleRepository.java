package co.ceiba.parking.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.ceiba.parking.Entity.VehicleEntity;

@Repository
public interface VehicleRepository extends CrudRepository<VehicleEntity, Long> {
	public VehicleEntity findByPlaca(String placa);
}
