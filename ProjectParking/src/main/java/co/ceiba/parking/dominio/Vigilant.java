package co.ceiba.parking.dominio;

import java.time.LocalDate;

import co.ceiba.parking.dominio.exception.VehicleException;
import co.ceiba.parking.persistence.entity.InvoiceEntity;
import co.ceiba.parking.persistence.entity.VehicleEntity;
import co.ceiba.parking.service.InvoiceService;
import co.ceiba.parking.service.UserService;
import co.ceiba.parking.service.VehicleService;

public class Vigilant {
	
	public static final int VALOR_HORA_CARRO = 1000;
	public static final int VALOR_HORA_MOTO = 500;
	public static final String NO_HAY_MAS_CUPOS_DISPONIBLES = "NO HAY CUPOS DISPONIBLE";
	
//	private UserRepository userRepository;
//	private VehicleRepository vehicleRepository;
//	private InvoiceRepository invoiceRepository;
	
	private UserService userService;
	private VehicleService vehicleService;
	private InvoiceService invoiceService;
	
	
//	public Vigilant(UserRepository userRepository, VehicleRepository vehicleRepository, InvoiceRepository invoiceRepository) {
//		this.userRepository = userRepository;
//		this.vehicleRepository = vehicleRepository;
//		this.invoiceRepository = invoiceRepository;
//	}
	
	public Vigilant(UserService userService, VehicleService vehicleService, InvoiceService invoiceService) {
		this.userService = userService;
		this.vehicleService = vehicleService;
		this.invoiceService = invoiceService;
	}
	
	public void InVehicle(String placa, String tipo) {
		LocalDate fechaIngreso = LocalDate.now();
		if(!isOccuped(placa)) {
			
			//this.vehicleRepository.
		} else {
			throw new VehicleException(NO_HAY_MAS_CUPOS_DISPONIBLES);
		}
	}
	
	public void outVehicle() {
		LocalDate fechaSalida = LocalDate.now();
	}
	
//	public boolean isOccuped(String placa) {
//		VehicleEntity vehicle = this.vehicleService.findByPlaca(placa);
////		VehicleEntity vehicle = this.vehicleRepository.getByPlaca(placa);
//		if(vehicle.getPlaca() != null) {
////			Invoice invoice = this.invoiceRepository.getByVehiculo(vehicle);
//			InvoiceEntity invoice = this.invoiceService.findById(vehicle.getId());
//			if(invoice.getSalida() != null) {
//				return true;
//			} else {
//				return false;
//			}
//		} else {
//			return false;
//		}
//	}
	
	public boolean isOccuped(String placa) {
		Vehicle vehicle = this.vehicleService.getByPlaca(placa);
		if(vehicle.getPlaca() != null) {
			Invoice invoice = this.invoiceService.getVehiculo(vehicle);
			if(invoice.getSalida() != null) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}
