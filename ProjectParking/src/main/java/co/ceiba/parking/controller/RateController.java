package co.ceiba.parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.ceiba.parking.persistence.entity.RateEntity;
import co.ceiba.parking.service.RateService;

@Controller
public class RateController {
	
	@Autowired
	private RateService rateService;
	
	@RequestMapping(value = "/rate", method = RequestMethod.GET)
	@ResponseBody
	public Object index() {
		return rateService.findAll();
	}
	
	@RequestMapping(value = "/createrate", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String create(@RequestBody RateEntity rateEntity) {
		String userId = "";
		try {
			rateService.save(rateEntity);
			userId = String.valueOf(rateEntity.getId());
		} catch (Exception ex) {
			return "Error creating the user: " + ex.toString();
		}
		return "User succesfully created with id = " + userId;

	}
	
	@RequestMapping("/deleterate/{id}")
	@ResponseBody
	public String delete(@PathVariable long id) {
		try {
			RateEntity rateEntity = rateService.findById(id);
			rateService.delete(rateEntity);
		} catch (Exception ex) {
			return "Error deleting the user:" + ex.toString();
		}
		return "User succesfully deleted!";
	}
	
	@RequestMapping("/updaterate/{id}")
	@ResponseBody
	public String updateVehicle(@RequestBody RateEntity rateEntity, @PathVariable Long id) {
		try {
			rateEntity.setId(id);
			rateService.save(rateEntity);
		} catch (Exception ex) {
			return "Error updating the user: " + ex.toString();
		}
		return "User succesfully updated!";
	}

}
