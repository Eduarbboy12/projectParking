package co.ceiba.parking.dominio;

import co.ceiba.parking.Service.UserService;
import co.ceiba.parking.persistence.entity.UserEntity;

public class Vigilant {
	
	public static final int VALOR_HORA_CARRO = 1000;
	public static final int VALOR_HORA_MOTO = 500;
	
	private UserService userService;
	
	public Vigilant(UserService userService) {
		this.userService = userService;
	}

	public void EnterUser(String mail) {
		UserEntity user = this.userService.findByEmail(mail);
	}

}
