package co.ceiba.parking.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

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
	
	public InvoiceEntity findById(long id) {
		return invoiceRepositoryJPA.findOne(id);
	}
	
	public InvoiceEntity save(InvoiceEntity invoice){
        return invoiceRepositoryJPA.save(invoice);
    }
	
	public void delete(InvoiceEntity invoice) {
		invoiceRepositoryJPA.delete(invoice);
		return;
	}
	
	public void validateInvoice(Vehicle vehicle) {
		LocalDateTime localInputDate = LocalDateTime.now();
		Date inputDate = Date.from(localInputDate.atZone(ZoneId.systemDefault()).toInstant());
		VehicleEntity vehicleEntity = vehicleRepositoryJPA.findByPlaque(vehicle.getPlaque());
		RateEntity rateEntity = rateRepositoryJPA.findByRateName("NA");
		InvoiceEntity invoiceEntity = new InvoiceEntity();
		invoiceEntity.setVehicle(vehicleEntity);
		invoiceEntity.setRateEntity(rateEntity);
		invoiceEntity.setDateinput(inputDate);		
		save(invoiceEntity);
	}
	
	public void ValidateUpdate(String plaque) {
		InvoiceEntity invoiceEntityCurrent = invoiceRepositoryJPA.findByVehiclePlaque(plaque);
		Invoice invoice = vigilant.outputVehicle(plaque);
		InvoiceEntity invoiceEntity = InvoiceBuilder.convertirAEntity(invoice);
		invoiceEntity.setId(invoiceEntityCurrent.getId());
		invoiceEntity.setRateEntity(invoiceEntityCurrent.getRateEntity());
		invoiceEntity.setVehicle(invoiceEntityCurrent.getVehicle());
		save(invoiceEntity);
		
	}

}
