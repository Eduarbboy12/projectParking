package co.ceiba.parking.persistence.repository.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.ceiba.parking.persistence.entity.UserEntity;

@Repository
public interface UserRepositoryJPA extends CrudRepository<UserEntity,Long> {
	public UserEntity findByMail(String mail);
	
}