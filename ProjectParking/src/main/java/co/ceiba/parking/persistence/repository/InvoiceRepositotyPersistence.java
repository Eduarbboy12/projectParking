package co.ceiba.parking.persistence.repository;

import co.ceiba.parking.dominio.repositorio.InvoiceRepository;
import co.ceiba.parking.persistence.repository.jpa.InvoiceRepositoryJPA;

public class InvoiceRepositotyPersistence implements InvoiceRepository {
	
	private InvoiceRepositoryJPA invoiceRepositoryJPA;
		
	public Long getByVehicleAndInvoiceStore(String type) {
		Long countvehicleStore = invoiceRepositoryJPA.countByVehicleType(type);
		return countvehicleStore;
	}

}
