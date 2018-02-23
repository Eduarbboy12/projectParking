package co.ceiba.parking.dominio;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.ceiba.parking.dominio.exception.VehicleException;
import co.ceiba.parking.persistence.builder.InvoiceBuilder;
import co.ceiba.parking.persistence.builder.VehicleBuilder;
import co.ceiba.parking.persistence.entity.InvoiceEntity;
import co.ceiba.parking.persistence.entity.VehicleEntity;
import co.ceiba.parking.persistence.repository.jpa.InvoiceRepositoryJPA;
import co.ceiba.parking.persistence.repository.jpa.RateRepositoryJPA;
import co.ceiba.parking.persistence.repository.jpa.UserRepositoryJPA;
import co.ceiba.parking.persistence.repository.jpa.VehicleRepositoryJPA;

@Service
public class Vigilant {

	public static final String NO_MORE_AVAILABLE_QUOTAS = "No hay cupos Disponibles";
	public static final String CAR_IS_ENTRY = "El carro ya se encuentra parqueado";
	public static final String CAR_NOT_IS_AUTORIZED_BY_PLACA = "El vehiculo no esta autorizado para parquear";
	public static final int SPACE_AVAILABLE_CAR = 20;
	public static final int SPACE_AVAILABLE_MOTORBYKE = 10;
	public static final String STATE_CAR = "CARRO";
	public static final String STATE_MOTORBYKE = "MOTO";

	@Autowired
	private VehicleRepositoryJPA vehicleRepositoryJPA;
	@Autowired
	private InvoiceRepositoryJPA invoiceRepositoryJPA;
	@Autowired
	private RateRepositoryJPA rateRepositoryJPA;
	@Autowired
	private UserRepositoryJPA userRepositoryJPA;
	
	public LocalDateTime inputDate = LocalDateTime.now();

	public Vigilant(VehicleRepositoryJPA vehicleRepositoryJPA, InvoiceRepositoryJPA invoiceRepositoryJPA, RateRepositoryJPA rateRepositoryJPA, UserRepositoryJPA userRepositoryJPA) {
		this.vehicleRepositoryJPA = vehicleRepositoryJPA;
		this.invoiceRepositoryJPA = invoiceRepositoryJPA;
		this.rateRepositoryJPA = rateRepositoryJPA;
		this.userRepositoryJPA = userRepositoryJPA;
	}
	
	public Vehicle inputVehicle(Vehicle vehicle) {
		ValidateInputVehicle(vehicle);
		return vehicle;
	}

	public void ValidateInputVehicle(Vehicle vehicle) {
		String placaValidate = vehicle.getPlaque().toUpperCase();
		if (isOccuped(vehicle.getPlaque())) {
			throw new VehicleException(CAR_IS_ENTRY);
		}
		if (placaValidate.charAt(0) == 'A') {
			if (!isAuthorized(inputDate)) {
				throw new VehicleException(CAR_NOT_IS_AUTORIZED_BY_PLACA);
			}
		}
		if (!spaceAvailable(vehicle)) {
			throw new VehicleException(NO_MORE_AVAILABLE_QUOTAS);
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
		if (!vehicleExist(plaque)) {
			return false;
		}
		Vehicle vehicle = isVehicleExist(plaque);
		if (vehicle == null || vehicle.getPlaque() == null) {
			return false;
		}

		Invoice invoice = isInvoiceExist(vehicle);
		if (invoice == null || invoice.getDateoutput() == null) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param plaque
	 * @return
	 */
	public boolean vehicleExist(String plaque) {
		VehicleEntity vehicleEntity = this.vehicleRepositoryJPA.findByPlaque(plaque);
		if (vehicleEntity != null && vehicleEntity.getPlaque() != null) {
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
		VehicleEntity vehicleEntity = this.vehicleRepositoryJPA.findByPlaque(plaque);
		Vehicle vehicle = VehicleBuilder.convertirADominio(vehicleEntity);
		if (vehicle != null && vehicle.getPlaque() != null) {
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
		InvoiceEntity invoiceEntity = this.invoiceRepositoryJPA.findByVehiclePlaque(vehicle.getPlaque());
		
		Invoice invoice = InvoiceBuilder.convertirADominio(invoiceEntity);
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
		if (dateOfWeek.equals(DayOfWeek.SUNDAY) || dateOfWeek.equals(DayOfWeek.MONDAY)) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param vehicle
	 * @return
	 */
	public boolean spaceAvailable(Vehicle vehicle) {
		if (vehicle.getType().equals(STATE_CAR)) {
			if (isSpaceAviableCar(vehicle, SPACE_AVAILABLE_CAR)) {
				return true;
			}
			return false;
		} else {
			if (isSpaceAviableMotorByke(vehicle, SPACE_AVAILABLE_MOTORBYKE)) {
				return true;
			}
			return false;
		}
	}

	/**
	 * 
	 * @param vehicle
	 * @param spaceAvialbleCar
	 * @return
	 */
	public boolean isSpaceAviableCar(Vehicle vehicle, int spaceAvialbleCar) {
		if (vehicle == null || vehicle.getType() == null) {
			return false;
		}		
		Long countCarStore = this.invoiceRepositoryJPA.countByVehicleType(vehicle.getType());
		if (countCarStore > spaceAvialbleCar) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param vehicle
	 * @param spaceAvialble
	 * @return
	 */
	public boolean isSpaceAviableMotorByke(Vehicle vehicle, int spaceAvialbleMotorByke) {
		if (vehicle == null || vehicle.getType() == null) {
			return false;
		}
		Long countCarStore = this.invoiceRepositoryJPA.countByVehicleType(vehicle.getType());
		if (countCarStore > spaceAvialbleMotorByke) {
			return false;
		}
		return true;
	}

}
