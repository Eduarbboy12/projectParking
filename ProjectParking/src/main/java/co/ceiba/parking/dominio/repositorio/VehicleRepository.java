package co.ceiba.parking.dominio.repositorio;

import co.ceiba.parking.dominio.Vehicle;

public interface VehicleRepository {

	/**
	 * 
	 * @param placa
	 * @return
	 */
	Vehicle getByPlaque(String plaque);
}
