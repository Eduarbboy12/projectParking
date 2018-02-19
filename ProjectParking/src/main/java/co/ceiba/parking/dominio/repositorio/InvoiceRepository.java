package co.ceiba.parking.dominio.repositorio;

import co.ceiba.parking.dominio.Invoice;
import co.ceiba.parking.dominio.Vehicle;

public interface InvoiceRepository {
	
	/**
	 * 
	 * @param vehicleEntity
	 * @return
	 */
	Invoice getByVehiculo(Vehicle vehicle);

}
