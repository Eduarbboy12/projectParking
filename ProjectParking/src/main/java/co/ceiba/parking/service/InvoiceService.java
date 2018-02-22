package co.ceiba.parking.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.ceiba.parking.dominio.Invoice;
import co.ceiba.parking.dominio.Vehicle;
import co.ceiba.parking.dominio.Vigilant;
import co.ceiba.parking.persistence.builder.InvoiceBuilder;
import co.ceiba.parking.persistence.entity.InvoiceEntity;
import co.ceiba.parking.persistence.entity.RateEntity;
import co.ceiba.parking.persistence.entity.VehicleEntity;
import co.ceiba.parking.persistence.repository.jpa.InvoiceRepositoryJPA;
import co.ceiba.parking.persistence.repository.jpa.RateRepositoryJPA;
import co.ceiba.parking.persistence.repository.jpa.VehicleRepositoryJPA;

@Service
public class InvoiceService {
	
	@Autowired
	private InvoiceRepositoryJPA invoiceRepositoryJPA;
	
	@Autowired
	private VehicleRepositoryJPA vehicleRepositoryJPA;
	
	@Autowired
	private RateRepositoryJPA rateRepositoryJPA;
	
	@Autowired
	private Vigilant vigilant;
	
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
	
	public void validateInvoice(Vehicle vehicle) {
		LocalDate inputDateInvoice = LocalDate.now();
		Date DateInto= Date.from(inputDateInvoice.atStartOfDay(ZoneId.systemDefault()).toInstant());
		VehicleEntity vehicleEntity = vehicleRepositoryJPA.findByPlaque(vehicle.getPlaque());
		RateEntity rateEntity = rateRepositoryJPA.findByRateName("NA");
		InvoiceEntity invoiceEntity = new InvoiceEntity();
		invoiceEntity.setVehicle(vehicleEntity);
		invoiceEntity.setRateEntity(rateEntity);
		invoiceEntity.setDateinput(DateInto);		
		save(invoiceEntity);
	}

}
