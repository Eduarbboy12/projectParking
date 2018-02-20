package co.ceiba.parking.persistence.repository;

import javax.persistence.EntityManager;

import co.ceiba.parking.dominio.User;
import co.ceiba.parking.dominio.repositorio.UserRepository;
import co.ceiba.parking.persistence.builder.UserBuilder;
import co.ceiba.parking.persistence.entity.UserEntity;
import co.ceiba.parking.persistence.repository.jpa.UserRepositoryJPA;

public class UserRepositoryPersistence implements UserRepository{
	
	private EntityManager entityManager;
	private UserRepositoryJPA userRepositoryJPA;
	
	public UserRepositoryPersistence(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public User getByUser(String user) {
		UserEntity userEntity = userRepositoryJPA.findByUser(user);
		return UserBuilder.convertirADominio(userEntity);
	}

}
