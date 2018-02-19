package co.ceiba.parking.persistence.repository.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.ceiba.parking.dominio.Vehicle;
import co.ceiba.parking.persistence.entity.InvoiceEntity;
import co.ceiba.parking.persistence.entity.VehicleEntity;

@Repository
public interface InvoiceRepositoryJPA extends CrudRepository<InvoiceEntity, Long> {
	
	public InvoiceEntity findByVehicle(Vehicle vehicle);
	
	public InvoiceEntity findByValortotal(double valorTotal);
	
}
