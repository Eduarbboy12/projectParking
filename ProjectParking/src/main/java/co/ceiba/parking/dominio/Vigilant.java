package co.ceiba.parking.dominio;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

import co.ceiba.parking.dominio.exception.VehicleException;
import co.ceiba.parking.service.InvoiceService;
import co.ceiba.parking.service.RateService;
import co.ceiba.parking.service.UserService;
import co.ceiba.parking.service.VehicleService;

public class Vigilant {

	public static final String NO_HAY_MAS_CUPOS_DISPONIBLES = "No hay cupos Disponibles";
	public static final String CAR_IS_ENTRY = "El carro ya se encuentra parqueado";
	public static final String CAR_NOT_IS_AUTORIZED_BY_PLACA = "El vehiculo no esta autorizado para parquear";

	private UserService userService;
	private VehicleService vehicleService;
	private InvoiceService invoiceService;
	private RateService rateService;

	public Vigilant(UserService userService, VehicleService vehicleService, InvoiceService invoiceService,
			RateService rateService) {
		this.userService = userService;
		this.vehicleService = vehicleService;
		this.invoiceService = invoiceService;
		this.rateService = rateService;
	}

	public void inputVehicle(Vehicle vehicle, String type) {
		LocalDateTime inputDate = LocalDateTime.now();
		if (!isOccuped(vehicle.getPlaque())) {
			String placaValidate = vehicle.getPlaque().toUpperCase();
			if (placaValidate.charAt(0) == 'A') {
				if(isAuthorized(inputDate)) {
					if(spaceAvailable()) {
						
					}
				} else {
					throw new VehicleException(CAR_NOT_IS_AUTORIZED_BY_PLACA);
				}
			} else {
				System.out.println("no inicia por la letra a");
			}
		} else {
			throw new VehicleException(CAR_IS_ENTRY);
		}
	}

	public void outputVehicle() {
		LocalDate outputDate = LocalDate.now();
	}

	/**
	 * 
	 * @param plaque
	 * @return
	 */
	public boolean isOccuped(String plaque) {
		if (vehicleExist(plaque)) {
			Vehicle vehicle = isVehicleExist(plaque);
			if (vehicle != null && vehicle.getPlaque() != null) {
				Invoice invoice = isInvoiceExist(vehicle);
				if (invoice != null && invoice.getDateoutput() != null) {
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
		if (vehicle != null && vehicle.getPlaque() != null && vehicle.getPlaque().equals(plaque)) {
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
		if (vehicle != null && vehicle.getPlaque() != null && vehicle.getPlaque().equals(plaque)) {
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
		if (invoice != null && invoice.getVehicle().getPlaque() != null) {
			return invoice;
		}
		return invoice;
	}
	
	/**
	 * 
	 * @param StartDate
	 * @return
	 */
	public boolean isAuthorized(LocalDateTime StartDate) {
		DayOfWeek dateOfWeek = StartDate.getDayOfWeek();
		System.out.println(dateOfWeek);
		if(dateOfWeek.equals(DayOfWeek.SUNDAY) || dateOfWeek.equals(DayOfWeek.MONDAY)) {
			return false;
		}
		return true;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean spaceAvailable() {
		return true;
	}

}
