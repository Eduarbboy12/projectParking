package co.ceiba.parking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.ceiba.parking.dominio.Vehicle;
import co.ceiba.parking.dominio.Vigilant;
import co.ceiba.parking.dominio.repositorio.InvoiceRepository;
import co.ceiba.parking.dominio.repositorio.RateRepository;
import co.ceiba.parking.dominio.repositorio.UserRepository;
import co.ceiba.parking.dominio.repositorio.VehicleRepository;
import co.ceiba.parking.persistence.builder.VehicleBuilder;
import co.ceiba.parking.persistence.entity.VehicleEntity;
import co.ceiba.parking.persistence.repository.jpa.VehicleRepositoryJPA;


@Service
public class VehicleService {
	
	@Autowired
	public Vigilant vigilant;
	
	@Autowired
	public InvoiceService invoiceService;
	
	private VehicleRepository vehicleRepository;
	private InvoiceRepository invoiceRepository;
	private RateRepository rateRepository;
	private UserRepository userRepository;
	
	@Autowired
	private VehicleRepositoryJPA vehicleRepositoryJPA;
	
	public Object findAll() {
		return vehicleRepositoryJPA.findAll();
	}
	
	public VehicleEntity findById(long Id) {
		return vehicleRepositoryJPA.findOne(Id);
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
	
	public Vehicle getByPlaque(String plaque) {
		return vehicleRepository.getByPlaque(plaque);
	}
	
	public void PreSave(Vehicle vehicle) {
		VehicleEntity vehicleEntity = VehicleBuilder.convertirAEntity(vehicle);
		save(vehicleEntity);
	}
	

}
