package co.ceiba.parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.ceiba.parking.persistence.entity.InvoiceEntity;
import co.ceiba.parking.service.InvoiceService;

@Controller
public class InvoiceController {
	
	@Autowired
	private InvoiceService invoiceService;

	@RequestMapping(value = "/invoice", method = RequestMethod.GET)
	@ResponseBody
	public Object index() {
		return invoiceService.findAll();
	}
	
	@RequestMapping(value = "/createInvoice", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String create(@RequestBody InvoiceEntity invoiceEntity) {
		String userId = "";
		try {
			invoiceService.save(invoiceEntity);
			userId = String.valueOf(invoiceEntity.getId());
		} catch (Exception ex) {
			return "Error creating the user: " + ex.toString();
		}
		return "User succesfully created with id = " + userId;

	}
	
	@RequestMapping("/updateinvoice/{id}")
	@ResponseBody
	public String updateVehicle(@RequestBody InvoiceEntity invoiceEntity, @PathVariable Long id) {
		try {
			invoiceEntity.setId(id);
			invoiceService.save(invoiceEntity);
		} catch (Exception ex) {
			return "Error updating the user: " + ex.toString();
		}
		return "User succesfully updated!";
	}
	
	
	@RequestMapping("/invoice/{plaque}")
	@ResponseBody
	public String updateVehicleByPlaque(@PathVariable String plaque) {
		try {
			invoiceService.ValidateUpdate(plaque);
		} catch (Exception ex) {
			return "Error updating the user: " + ex.toString();
		}
		return "User succesfully updated!";
	}
	

}
