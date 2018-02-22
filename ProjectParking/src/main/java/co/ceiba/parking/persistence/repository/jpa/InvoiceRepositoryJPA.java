package co.ceiba.parking.persistence.repository.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.ceiba.parking.dominio.Vehicle;
import co.ceiba.parking.persistence.entity.InvoiceEntity;

@Repository
public interface InvoiceRepositoryJPA extends CrudRepository<InvoiceEntity, Long> {
	
	public InvoiceEntity findByValuepay(double valuepay);
	
	public Long countByVehicleType(String type);
	
	public InvoiceEntity findByVehiclePlaque(String plaque);
	
}
