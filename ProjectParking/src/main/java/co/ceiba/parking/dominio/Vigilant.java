package co.ceiba.parking.dominio;

import java.time.LocalDate;

import co.ceiba.parking.dominio.exception.VehicleException;
import co.ceiba.parking.persistence.entity.InvoiceEntity;
import co.ceiba.parking.persistence.entity.VehicleEntity;
import co.ceiba.parking.service.InvoiceService;
import co.ceiba.parking.service.RateService;
import co.ceiba.parking.service.UserService;
import co.ceiba.parking.service.VehicleService;

public class Vigilant {
	
	public static final int VALOR_HORA_CARRO = 1000;
	public static final int VALOR_HORA_MOTO = 500;
	public static final String NO_HAY_MAS_CUPOS_DISPONIBLES = "No hay cupos Disponibles";
	public static final String CAR_IS_ENTRY = "El carro ya se encuentra ingresado";
	
	private UserService userService;
	private VehicleService vehicleService;
	private InvoiceService invoiceService;
	private RateService rateService; 
	
	public Vigilant(UserService userService, VehicleService vehicleService, InvoiceService invoiceService, RateService rateService) {
		this.userService = userService;
		this.vehicleService = vehicleService;
		this.invoiceService = invoiceService;
		this.rateService = rateService;
	}
	
	public void InputVehicle(String plaque, String type) {
		LocalDate inputDate = LocalDate.now();
		if(!isOccuped(plaque)) {
			
			
			
			//this.vehicleRepository.
		} else {
			throw new VehicleException(CAR_IS_ENTRY);
		}
	}
	
	public void outVehicle() {
		LocalDate outputDate = LocalDate.now();
	}
	
	/**
	 * 
	 * @param plaque
	 * @return
	 */
	public boolean isOccuped(String plaque) {
		if(vehicleExist(plaque)) {
			Vehicle vehicle = isVehicleExist(plaque);
			if(vehicle != null && vehicle.getPlaque() != null) {
				Invoice invoice =isInvoiceExist(vehicle);
				if(invoice != null && invoice.getDateoutput() != null) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param plaque
	 * @return
	 */
	public boolean vehicleExist(String plaque) {
		Vehicle vehicle = this.vehicleService.getByPlaque(plaque);
		if(vehicle != null && vehicle.getPlaque() != null &&  vehicle.getPlaque().equals(plaque)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @param plaque
	 * @return
	 */
	public Vehicle isVehicleExist(String plaque) {
		Vehicle vehicle = this.vehicleService.getByPlaque(plaque);
		if(vehicle != null && vehicle.getPlaque() != null &&  vehicle.getPlaque().equals(plaque)) {
			return vehicle;
		}
		return vehicle;
	}
	
	/**
	 * 
	 * @param vehicle
	 * @return
	 */
	public Invoice isInvoiceExist(Vehicle vehicle) {
		Invoice invoice = this.invoiceService.getVehiculo(vehicle);
		if(invoice != null && invoice.getVehicleEntity().getPlaque() != null) {
			return invoice;
		}
		return invoice;
	}
	

}
