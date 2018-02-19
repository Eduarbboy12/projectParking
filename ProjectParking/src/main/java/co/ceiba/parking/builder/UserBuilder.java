package co.ceiba.parking.builder;

import co.ceiba.parking.Entity.UserEntity;
import co.ceiba.parking.dominio.User;

public class UserBuilder {

	public UserBuilder() {
	}

	public static User convertirADominio(UserEntity userEntity) {
		User user = null;
		if (userEntity != null) {
			user = new User(userEntity.getNombre(), userEntity.getApellido(), userEntity.getDireccion(),
					userEntity.getDocumento(), userEntity.getMail(), userEntity.getTelefono());
		}
		return user;

	}

}
