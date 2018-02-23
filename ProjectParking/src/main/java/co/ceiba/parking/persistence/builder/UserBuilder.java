package co.ceiba.parking.persistence.builder;

import co.ceiba.parking.dominio.User;
import co.ceiba.parking.persistence.entity.UserEntity;

public class UserBuilder {

	/**
	 * Contructor
	 */
	public UserBuilder() {
	}

	public static User convertirADominio(UserEntity userEntity) {
		User user = null;
		if (userEntity != null) {
			user = new User(userEntity.getName(), userEntity.getLastName(), userEntity.getDocument(),
					userEntity.getUser());
		}
		return user;
	}
	
	public static UserEntity convertirAEntity(User user) {
		UserEntity userEntity = new UserEntity();
		userEntity.setName(user.getName());
		userEntity.setLastName(user.getLastName());
		userEntity.setDocument(user.getDocument());
		userEntity.setUser(user.getUser());
		return userEntity;
	}

}
