package co.ceiba.parking.dominio;

import java.time.LocalDate;

import co.ceiba.parking.dominio.exception.VehicleException;
import co.ceiba.parking.dominio.repositorio.InvoiceRepository;
import co.ceiba.parking.dominio.repositorio.UserRepository;
import co.ceiba.parking.dominio.repositorio.VehicleRepository;

public class Vigilant {
	
	public static final int VALOR_HORA_CARRO = 1000;
	public static final int VALOR_HORA_MOTO = 500;
	public static final String NO_HAY_MAS_CUPOS_DISPONIBLES = "NO HAY CUPOS DISPONIBLE";
	
	private UserRepository userRepository;
	private VehicleRepository vehicleRepository;
	private InvoiceRepository invoiceRepository;
	
	public Vigilant(UserRepository userRepository, VehicleRepository vehicleRepository, InvoiceRepository invoiceRepository) {
		this.userRepository = userRepository;
		this.vehicleRepository = vehicleRepository;
		this.invoiceRepository = invoiceRepository;
	}
	
	public void EnterVehicle(String placa, String tipo) {
		LocalDate fechaActual = LocalDate.now();
		if(!isOccuped(placa)) {
			
			//this.vehicleRepository.
		} else {
			throw new VehicleException(NO_HAY_MAS_CUPOS_DISPONIBLES);
		}
	}
	
	public boolean isOccuped(String placa) {
		Vehicle vehicle = this.vehicleRepository.getByPlaca(placa);
		if(vehicle.getPlaca() != null) {
			Invoice invoice = this.invoiceRepository.getByVehiculo(vehicle);
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
