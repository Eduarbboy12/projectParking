package co.ceiba.parking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.ceiba.parking.dominio.Vigilant;
import co.ceiba.parking.persistence.entity.VehicleEntity;
import co.ceiba.parking.persistence.repository.jpa.VehicleRepositoryJPA;


@Service
public class VehicleService {
	
	public Vigilant vigilant;
	
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
	
	public VehicleEntity findByPlaca(String placa) {
		return vehicleRepositoryJPA.findByPlaca(placa);
	}
	
	public VehicleEntity findByTipo(String tipo) {
		return vehicleRepositoryJPA.findByTipo(tipo);
	}
	
	public void saveController(VehicleEntity vehicle) {
		vigilant.InVehicle(vehicle.getPlaca(), vehicle.getTipo());
	}
	

}
