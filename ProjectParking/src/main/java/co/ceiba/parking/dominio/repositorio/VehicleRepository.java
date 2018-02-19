package co.ceiba.parking.dominio.repositorio;

import co.ceiba.parking.dominio.Vehicle;

public interface VehicleRepository {

	/**
	 * 
	 * @param placa
	 * @return
	 */
	Vehicle getByPlaca(String placa);
	
	/**
	 * 
	 * @param vehicle
	 */
	void saveVehiculo(Vehicle vehicle);
}
