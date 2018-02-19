package co.ceiba.parking.persistence.builder;

import co.ceiba.parking.dominio.User;
import co.ceiba.parking.persistence.entity.UserEntity;

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
	
	public static UserEntity convertirAEntity(User user) {
		UserEntity userEntity = new UserEntity();
		userEntity.setNombre(user.getNombre());
		userEntity.setApellido(user.getApellido());
		userEntity.setDireccion(user.getDireccion());
		userEntity.setDocumento(user.getDocumento());
		userEntity.setMail(user.getMail());
		userEntity.setTelefono(user.getTelefono());
		return userEntity;
	}

}
