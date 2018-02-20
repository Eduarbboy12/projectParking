package co.ceiba.parking.dominio;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import co.ceiba.parking.service.InvoiceService;
import co.ceiba.parking.service.RateService;
import co.ceiba.parking.service.UserService;
import co.ceiba.parking.service.VehicleService;
import co.ceiba.parking.testdatabuilder.VehicleTestDataBuilder;

public class VigilantTest {

	@Test
	public void vehicleExistTest() {
		
		// arrange
		VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder();
		
		Vehicle vehicle = vehicleTestDataBuilder.build();
		
		UserService userService = mock(UserService.class);
		VehicleService vehicleService = mock(VehicleService.class);
		InvoiceService invoiceService = mock(InvoiceService.class);
		RateService rateService = mock(RateService.class);
		
		when(vehicleService.getByPlaque(vehicle.getPlaque())).thenReturn(vehicle);
		
		Vigilant vigilante = new Vigilant(userService, vehicleService, invoiceService, rateService);
		
		// act
		boolean vehicleExist = vigilante.vehicleExist(vehicle.getPlaque());
		
		// Assert
		assertTrue(vehicleExist);
	}
	
	@Test
	public void vehicleNoExistTest() {
		
		// arrange
		VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder();
		
		Vehicle vehicle = vehicleTestDataBuilder.build();
		
		UserService userService = mock(UserService.class);
		VehicleService vehicleService = mock(VehicleService.class);
		InvoiceService invoiceService = mock(InvoiceService.class);
		RateService rateService = mock(RateService.class);
		
		when(vehicleService.getByPlaque(vehicle.getPlaque())).thenReturn(null);
		
		Vigilant vigilante = new Vigilant(userService, vehicleService, invoiceService, rateService);
		
		// act
		boolean vehicleExist = vigilante.vehicleExist(vehicle.getPlaque());
		
		// Assert
		assertFalse(vehicleExist);
	}
	
	@Test
	public void isVehicleExistTest() {
		
		// arrange
		VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder();
		
		Vehicle vehicle = vehicleTestDataBuilder.build();
		
		UserService userService = mock(UserService.class);
		VehicleService vehicleService = mock(VehicleService.class);
		InvoiceService invoiceService = mock(InvoiceService.class);
		RateService rateService = mock(RateService.class);
		
		when(vehicleService.getByPlaque(vehicle.getPlaque())).thenReturn(vehicle);
		
		Vigilant vigilante = new Vigilant(userService, vehicleService, invoiceService, rateService);
		
		// act
		Vehicle vehicleExist = vigilante.isVehicleExist(vehicle.getPlaque());
		
		// Assert
		assertEquals(vehicleExist.getType(), vehicle.getType());
		assertEquals(vehicleExist.getPlaque(), vehicle.getPlaque());
		assertEquals(vehicleExist.getDocument(), vehicle.getDocument());
		assertEquals(vehicleExist.getCylinder(), vehicle.getCylinder());
	}
	
	@Test
	public void isVehicleNoExistTest() {
		
		// arrange
		VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder();
		
		Vehicle vehicle = vehicleTestDataBuilder.build();
		
		UserService userService = mock(UserService.class);
		VehicleService vehicleService = mock(VehicleService.class);
		InvoiceService invoiceService = mock(InvoiceService.class);
		RateService rateService = mock(RateService.class);
		
		when(vehicleService.getByPlaque(vehicle.getPlaque())).thenReturn(null);
		
		Vigilant vigilante = new Vigilant(userService, vehicleService, invoiceService, rateService);
		
		// act
		Vehicle vehicleExists = vigilante.isVehicleExist(vehicle.getPlaque());
		
		// Assert		
		assertNull(vehicleExists);
	}
	
	@Test
	public void isInvoiceExistTest() {
		
		// arrange
//		InvoiceTest vehicleTestDataBuilder = new VehicleTestDataBuilder();
//		
//		Vehicle vehicle = vehicleTestDataBuilder.build();
//		
//		UserService userService = mock(UserService.class);
//		VehicleService vehicleService = mock(VehicleService.class);
//		InvoiceService invoiceService = mock(InvoiceService.class);
//		RateService rateService = mock(RateService.class);
//		
//		when(vehicleService.getByPlaque(vehicle.getPlaque())).thenReturn(vehicle);
//		
//		Vigilant vigilante = new Vigilant(userService, vehicleService, invoiceService, rateService);
//		
//		// act
//		Vehicle vehicleExist = vigilante.isVehicleExist(vehicle.getPlaque());
//		
//		// Assert
//		assertEquals(vehicleExist.getType(), vehicle.getType());
//		assertEquals(vehicleExist.getPlaque(), vehicle.getPlaque());
//		assertEquals(vehicleExist.getDocument(), vehicle.getDocument());
//		assertEquals(vehicleExist.getCylinder(), vehicle.getCylinder());
	}

}
