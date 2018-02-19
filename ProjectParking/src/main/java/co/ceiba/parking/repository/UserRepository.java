package co.ceiba.parking.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.ceiba.parking.Entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,Long> {
	public UserEntity findByMail(String mail);
	
}