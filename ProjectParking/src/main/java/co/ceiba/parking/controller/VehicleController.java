package co.ceiba.parking.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
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
			vehicleService.saveValidate(vehicleEntity);
			userId = String.valueOf(vehicleEntity.getPlaque());
		} catch (Exception ex) {
			Logger.getLogger(ex.getMessage());
			return "Error creating the vehicle: " + ex.toString();
		}
		return "User succesfully created with id = " + userId;
	}

}
