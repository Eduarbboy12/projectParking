package co.ceiba.parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.ceiba.parking.persistence.entity.VehicleEntity;
import co.ceiba.parking.service.VehicleService;

@Controller
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;

	@RequestMapping(value = "/vehicle", method = RequestMethod.GET)
	@ResponseBody
	public Object index() {
		return vehicleService.findAll();
	}
	
	@RequestMapping(value = "/createvehicle", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String create(@RequestBody VehicleEntity vehicleEntity) {
		String userId = "";
		try {
			vehicleService.saveController(vehicleEntity);
			userId = String.valueOf(vehicleEntity.getId());
		} catch (Exception ex) {
			return "Error creating the user: " + ex.toString();
		}
		return "User succesfully created with id = " + userId;

	}
	
	@RequestMapping("/deletevehicle/{id}")
	@ResponseBody
	public String delete(@PathVariable long id) {
		try {
			VehicleEntity vehicleEntity = vehicleService.findById(id);
			vehicleService.delete(vehicleEntity);
		} catch (Exception ex) {
			return "Error deleting the user:" + ex.toString();
		}
		return "User succesfully deleted!";
	}
	
	@RequestMapping("/updatevehicle/{id}")
	@ResponseBody
	public String updateVehicle(@RequestBody VehicleEntity vehicleEntity, @PathVariable Long id) {
		try {
			vehicleEntity.setId(id);
			vehicleService.save(vehicleEntity);
		} catch (Exception ex) {
			return "Error updating the user: " + ex.toString();
		}
		return "User succesfully updated!";
	}

}
