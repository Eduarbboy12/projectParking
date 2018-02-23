package co.ceiba.parking.dominio;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.ceiba.parking.dominio.exception.InvoiceException;
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
	public static final String PLAQUE_NOT_STORE = "La placa ingresada ya no esta en el sistema";
	public static final String VEHICLE_IS_EXIT = "El carro ya salio del sistema";
	public static final int SPACE_AVAILABLE_CAR = 20;
	public static final int SPACE_AVAILABLE_MOTORBYKE = 10;
	public static final int CYLINDER_AVIABLE = 500;
	public static final String STATE_CAR = "CARRO";
	public static final String STATE_MOTORBYKE = "MOTO";
	public static final int HORADIA = 24;
	public static final int HORADIAMAX = 9;
	public static final int VALUE_HOUR_MOTORBYKE = 500;
	public static final int VALUE_DAY_MOTORBYKE = 4000;
	public static final int VALUE_HOUR_CAR = 1000;
	public static final int VALUE_DAY_CAR = 8000;

	@Autowired
	private VehicleRepositoryJPA vehicleRepositoryJPA;
	@Autowired
	private InvoiceRepositoryJPA invoiceRepositoryJPA;
	@Autowired
	private RateRepositoryJPA rateRepositoryJPA;
	@Autowired
	private UserRepositoryJPA userRepositoryJPA;

	public static final LocalDateTime currentDate = LocalDateTime.now();

	/**
	 * 
	 * @param vehicleRepositoryJPA
	 * @param invoiceRepositoryJPA
	 * @param rateRepositoryJPA
	 * @param userRepositoryJPA
	 */
	public Vigilant(VehicleRepositoryJPA vehicleRepositoryJPA, InvoiceRepositoryJPA invoiceRepositoryJPA,
			RateRepositoryJPA rateRepositoryJPA, UserRepositoryJPA userRepositoryJPA) {
		this.vehicleRepositoryJPA = vehicleRepositoryJPA;
		this.invoiceRepositoryJPA = invoiceRepositoryJPA;
		this.rateRepositoryJPA = rateRepositoryJPA;
		this.userRepositoryJPA = userRepositoryJPA;
	}

	/**
	 * 
	 * @param vehicle
	 * @return
	 */
	public Vehicle inputVehicle(Vehicle vehicle) {
		validateInputVehicle(vehicle);
		return vehicle;
	}

	/**
	 * 
	 * @param vehicle
	 */
	public void validateInputVehicle(Vehicle vehicle) {
		String placaValidate = vehicle.getPlaque().toUpperCase();
		if (isOccuped(vehicle.getPlaque())) {
			throw new VehicleException(CAR_IS_ENTRY);
		}
		if (placaValidate.charAt(0) == 'A' && !isAuthorized(currentDate)) {
			throw new VehicleException(CAR_NOT_IS_AUTORIZED_BY_PLACA);
		}
		if (!spaceAvailable(vehicle)) {
			throw new VehicleException(NO_MORE_AVAILABLE_QUOTAS);
		}

	}

	/**
	 * 
	 * @param plaque
	 */
	public Invoice outputVehicle(String plaque) {
		if(plaque == null) {
			throw new InvoiceException(PLAQUE_NOT_STORE);
		}
		int days = 0;
		int hour = 0;
		int minute = 0;
		int valuePay = 0;
		InvoiceEntity invoiceEntity = this.invoiceRepositoryJPA.findByVehiclePlaque(plaque);
		Invoice invoice = InvoiceBuilder.convertirADominio(invoiceEntity);
		if(invoice == null || invoice.getVehicle() == null || invoice.getVehicle().getPlaque() == null || invoice.getDateoutput() != null) {
			throw new VehicleException(PLAQUE_NOT_STORE);
		}
		Date exitDate = Date.from(currentDate.atZone(ZoneId.systemDefault()).toInstant());
		int diff = (int) ((exitDate.getTime() - invoice.getDateinput().getTime()) / 1000);
		if (diff > 86400) {
			days = (int) Math.floor(diff / 86400);
			diff = diff - (days * 86400);
		}
		if (diff > 3600) {
			hour = (int) Math.floor(diff / 3600);
			diff = diff - (hour * 3600);
		}
		if (diff > 60) {
			minute = (int) Math.floor(diff / 60);
			diff = diff - (minute * 60);
		}

		if ((minute % 60) >= 1) {
			hour++;
			minute = 0;
		}
		if (hour > 9) {
			days++;
			hour = 0;
		}
		if (invoice.getVehicle().getType().equals(STATE_CAR)) {
			valuePay = (days * VALUE_DAY_CAR) + (hour * VALUE_HOUR_CAR);
		} else {
			valuePay = (days * VALUE_DAY_MOTORBYKE) + (hour * VALUE_HOUR_MOTORBYKE);
		}
		if (Integer.parseInt(invoice.getVehicle().getCylinder()) > CYLINDER_AVIABLE) {
			valuePay += 2000;
		}
		invoice.setDateoutput(exitDate);
		invoice.setTimeparking(days);
		invoice.setValuepay(valuePay);
		return invoice;
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
	 * @param startDate
	 * @return
	 */
	public boolean isAuthorized(LocalDateTime startDate) {
		DayOfWeek dateOfWeek = startDate.getDayOfWeek();
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
