package co.ceiba.parking.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.ceiba.parking.Entity.Vehicle;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
	public Vehicle findByPlaca(String placa);
}
