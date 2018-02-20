package co.ceiba.parking.dominio.repositorio;

import co.ceiba.parking.dominio.User;

public interface UserRepository {
	
	/**
	 * 
	 * @param mail
	 * @return
	 */
	User getByUser(String user);

}
