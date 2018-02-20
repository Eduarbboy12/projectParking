package co.ceiba.parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.ceiba.parking.persistence.entity.UserEntity;
import co.ceiba.parking.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	@ResponseBody
	public Object index() {
		return userService.findAll();
	}

	@RequestMapping(value = "/create", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String create(@RequestBody UserEntity user) {
		String userId = "";
		try {
			userService.save(user);
			userId = String.valueOf(user.getId());
		} catch (Exception ex) {
			return "Error creating the user: " + ex.toString();
		}
		return "User succesfully created with id = " + userId;

	}
	
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public String delete(@PathVariable long id) {
		try {
			UserEntity user = userService.findById(id);
			userService.delete(user);
		} catch (Exception ex) {
			return "Error deleting the user:" + ex.toString();
		}
		return "User succesfully deleted!";
	}

	@RequestMapping("/update/{id}")
	@ResponseBody
	public String updateUser(@RequestBody UserEntity user, @PathVariable Long id) {
		try {
			user.setId(id);
			userService.save(user);
		} catch (Exception ex) {
			return "Error updating the user: " + ex.toString();
		}
		return "User succesfully updated!";
	}
	
	@RequestMapping(value = "/get-by-email/{mail}", method = RequestMethod.GET)
	@ResponseBody
	public Object getByUser(@PathVariable String user) {
		System.out.println("controller:" + userService.findByUser(user));
		return userService.findByUser(user);
	}
	
}
