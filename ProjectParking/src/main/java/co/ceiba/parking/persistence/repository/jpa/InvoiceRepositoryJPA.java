package co.ceiba.parking.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.ceiba.parking.Entity.InvoiceEntity;
import co.ceiba.parking.Entity.VehicleEntity;

@Repository
public interface InvoiceRepository extends CrudRepository<InvoiceEntity, Long> {
	public InvoiceEntity findByVehicle(VehicleEntity vehicle);
}
