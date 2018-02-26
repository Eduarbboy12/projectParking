package co.ceiba.parking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.ceiba.parking.dominio.Vehicle;
import co.ceiba.parking.dominio.Vigilant;
import co.ceiba.parking.persistence.builder.VehicleBuilder;
import co.ceiba.parking.persistence.entity.VehicleEntity;
import co.ceiba.parking.persistence.repository.jpa.VehicleRepositoryJPA;


@Service
public class VehicleService {
	
	@Autowired
	public Vigilant vigilant;
	
	@Autowired
	public InvoiceService invoiceService;
	
	@Autowired
	private VehicleRepositoryJPA vehicleRepositoryJPA;
	
	public Object findAll() {
		return vehicleRepositoryJPA.findAll();
	}
	
	public VehicleEntity findById(long id) {
		return vehicleRepositoryJPA.findOne(id);
	}
	
	public VehicleEntity save(VehicleEntity vehicle){
        return vehicleRepositoryJPA.save(vehicle);
    }
	
	public void delete(VehicleEntity vehicle) {
		vehicleRepositoryJPA.delete(vehicle);
		return;
	}
	
	public VehicleEntity findByPlaque(String plaque) {
		return vehicleRepositoryJPA.findByPlaque(plaque);
	}
	
	public VehicleEntity findByTipo(String type) {
		return vehicleRepositoryJPA.findByType(type);
	}
	
	public void saveValidate(VehicleEntity vehicleEntity) {
		Vehicle vehicle = VehicleBuilder.convertirADominio(vehicleEntity);
		Vehicle vehiclePreSave = vigilant.inputVehicle(vehicle);
		VehicleEntity vehicleEntitySave = VehicleBuilder.convertirAEntity(vehiclePreSave);
		save(vehicleEntitySave);
		invoiceService.validateInvoice(vehiclePreSave);
	}
	
	public void preSave(Vehicle vehicle) {
		VehicleEntity vehicleEntity = VehicleBuilder.convertirAEntity(vehicle);
		save(vehicleEntity);
	}
	

}
