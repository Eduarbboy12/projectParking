package co.ceiba.parking.persistence.repository.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.ceiba.parking.dominio.Vehicle;
import co.ceiba.parking.persistence.entity.VehicleEntity;

@Repository
public interface VehicleRepositoryJPA extends CrudRepository<VehicleEntity, Long> {
	public VehicleEntity findByPlaca(String placa);
	
	public VehicleEntity findByTipo(String tipo);
}
