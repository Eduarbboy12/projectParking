package co.ceiba.parking.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.ceiba.parking.Entity.User;

import co.ceiba.parking.Service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)		
	@ResponseBody
	public Object index(){ 
		return userService.findAll();
	}
	
	public String create(@RequestBody User user) {
		String userId = "";
		try {
			userService.save(user);
			userId = String.valueOf(user.getId());
			
		}catch(Exception ex) {
			return "Error creating the user: " + ex.toString();
		}
		return "User succesfully created with id = " + userId;
		
	}
	
}
