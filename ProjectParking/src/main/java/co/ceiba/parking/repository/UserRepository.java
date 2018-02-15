package co.ceiba.parking.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.ceiba.parking.Entity.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
	//public User findById(Long Id);
	/***public Person findUsingEmail(String email);******/
	
}