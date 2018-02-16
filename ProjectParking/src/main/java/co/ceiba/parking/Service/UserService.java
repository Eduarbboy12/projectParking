package co.ceiba.parking.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.ceiba.parking.Entity.User;
import co.ceiba.parking.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public Object findAll(){
        return userRepository.findAll();
    }
	
	public User findById(long Id) {
		return userRepository.findOne(Id);
	}
	
	public User save(User user){
        return userRepository.save(user);
    }
	
	public void delete(User user) {
		userRepository.delete(user);
		return;
	}
	
	public User findByEmail(String mail) {
		return userRepository.findByMail(mail);
	}

}
