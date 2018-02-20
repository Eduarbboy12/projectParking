package co.ceiba.parking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.ceiba.parking.persistence.entity.UserEntity;
import co.ceiba.parking.persistence.repository.jpa.UserRepositoryJPA;

@Service
public class UserService {
	
	@Autowired
	private UserRepositoryJPA userRepository;
	
	public Object findAll(){
        return userRepository.findAll();
    }
	
	public UserEntity findById(long Id) {
		return userRepository.findOne(Id);
	}
	
	public UserEntity save(UserEntity user){
        return userRepository.save(user);
    }
	
	public void delete(UserEntity user) {
		userRepository.delete(user);
		return;
	}
	
	public UserEntity findByUser(String user) {
		return userRepository.findByUser(user);
	}

}
