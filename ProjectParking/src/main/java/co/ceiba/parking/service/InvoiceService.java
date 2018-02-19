package co.ceiba.parking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.ceiba.parking.persistence.entity.InvoiceEntity;
import co.ceiba.parking.persistence.repository.jpa.InvoiceRepositoryJPA;

@Service
public class InvoiceService {
	
	@Autowired
	private InvoiceRepositoryJPA invoiceRepositoryJPA;
	
	public Object findAll() {
		return invoiceRepositoryJPA.findAll();
	}
	
	public InvoiceEntity findById(long Id) {
		return invoiceRepositoryJPA.findOne(Id);
	}
	
	public InvoiceEntity save(InvoiceEntity invoice){
        return invoiceRepositoryJPA.save(invoice);
    }
	
	public void delete(InvoiceEntity invoice) {
		invoiceRepositoryJPA.delete(invoice);
		return;
	}

}
