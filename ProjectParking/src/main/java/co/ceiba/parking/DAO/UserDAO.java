package co.ceiba.parking.DAO;

import java.util.Map;
import org.springframework.stereotype.Repository;
import co.ceiba.parking.Entity.User;

@Repository
public class UserDAO {
	
	private static Map<Integer, User> users;

}
