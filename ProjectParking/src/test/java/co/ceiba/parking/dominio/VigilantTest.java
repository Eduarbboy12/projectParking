package co.ceiba.parking.dominio;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

import co.ceiba.parking.service.InvoiceService;
import co.ceiba.parking.service.RateService;
import co.ceiba.parking.service.UserService;
import co.ceiba.parking.service.VehicleService;
import co.ceiba.parking.testdatabuilder.InvoiceTestDataBuilder;
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
		InvoiceTestDataBuilder invoiceTestDataBuilder = new InvoiceTestDataBuilder();
		
		Invoice invoice = invoiceTestDataBuilder.build();
		
		UserService userService = mock(UserService.class);
		VehicleService vehicleService = mock(VehicleService.class);
		InvoiceService invoiceService = mock(InvoiceService.class);
		RateService rateService = mock(RateService.class);
		
		when(invoiceService.getVehiculo(invoice.getVehicle())).thenReturn(invoice);
		
		Vigilant vigilante = new Vigilant(userService, vehicleService, invoiceService, rateService);
		
		// act
		Invoice invoiceExist = vigilante.isInvoiceExist(invoice.getVehicle());
		
		// Assert
		assertEquals(invoiceExist.getVehicle().getType(), invoice.getVehicle().getType());
		assertEquals(invoiceExist.getVehicle().getPlaque(), invoice.getVehicle().getPlaque());
		assertEquals(invoiceExist.getVehicle().getDocument(), invoice.getVehicle().getDocument());
		assertEquals(invoiceExist.getVehicle().getCylinder(), invoice.getVehicle().getCylinder());
	}
	
	@Test
	public void isInvoiceNoExistTest() {
		
		// arrange
		InvoiceTestDataBuilder invoiceTestDataBuilder = new InvoiceTestDataBuilder();
		
		Invoice invoice = invoiceTestDataBuilder.build();
		
		UserService userService = mock(UserService.class);
		VehicleService vehicleService = mock(VehicleService.class);
		InvoiceService invoiceService = mock(InvoiceService.class);
		RateService rateService = mock(RateService.class);
		
		when(invoiceService.getVehiculo(invoice.getVehicle())).thenReturn(null);
		
		Vigilant vigilante = new Vigilant(userService, vehicleService, invoiceService, rateService);
		
		// act
		Invoice invoiceExist = vigilante.isInvoiceExist(invoice.getVehicle());
		
		// Assert		
		assertNull(invoiceExist);
	}

	@Test
	public void isOccupedExistTest() {
		
		// arrange
		VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder();
		
		Vehicle vehicle = vehicleTestDataBuilder.conPlaque("ABC123").build();
		
		UserService userService = mock(UserService.class);
		VehicleService vehicleService = mock(VehicleService.class);
		InvoiceService invoiceService = mock(InvoiceService.class);
		RateService rateService = mock(RateService.class);
		
		when(vehicleService.getByPlaque(vehicle.getPlaque())).thenReturn(vehicle);
		
		Vigilant vigilante = new Vigilant(userService, vehicleService, invoiceService, rateService);
		
		// act
		boolean vehicleIsOccuped = vigilante.isOccuped(vehicle.getPlaque());
		
		// Assert
		assertTrue(vehicleIsOccuped);
	}
	
	@Test
	public void isNotOccupedExistTest() {
		
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
		boolean vehicleIsOccuped = vigilante.isOccuped(vehicle.getPlaque());
		
		// Assert
		assertFalse(vehicleIsOccuped);
	}
	
	@Test
	public void inputVehicleTest() {
		
		// arrange
		InvoiceTestDataBuilder invoiceTestDataBuilder = new InvoiceTestDataBuilder();
		
		Invoice invoice = invoiceTestDataBuilder.build();
		
		UserService userService = mock(UserService.class);
		VehicleService vehicleService = mock(VehicleService.class);
		InvoiceService invoiceService = mock(InvoiceService.class);
		RateService rateService = mock(RateService.class);
		
		Vigilant vigilante = new Vigilant(userService, vehicleService, invoiceService, rateService);
		
		// act
		vigilante.inputVehicle(invoice.getVehicle(), invoice.getVehicle().getType());
		
		// Assert
		Assert.assertTrue(true);
		
	}
	
	@Test
	public void isNotAuthorizedTest() {
		
		// Arrange
		
		LocalDateTime StartDateValidate = LocalDateTime.of(2018, Calendar.FEBRUARY, 28, 10, 10);
		
		UserService userService = mock(UserService.class);
		VehicleService vehicleService = mock(VehicleService.class);
		InvoiceService invoiceService = mock(InvoiceService.class);
		RateService rateService = mock(RateService.class);
		
		Vigilant vigilante = new Vigilant(userService, vehicleService, invoiceService, rateService);
		
		// act
		vigilante.isAuthorized(StartDateValidate);
		
		// Assert
		Assert.assertFalse(vigilante.isAuthorized(StartDateValidate));
	}
	
	@Test
	public void isAuthorizedTest() {
		
		// Arrange
		
		LocalDateTime StartDateValidate = LocalDateTime.of(2018, Calendar.FEBRUARY, 20, 10, 10);
		
		UserService userService = mock(UserService.class);
		VehicleService vehicleService = mock(VehicleService.class);
		InvoiceService invoiceService = mock(InvoiceService.class);
		RateService rateService = mock(RateService.class);
		
		Vigilant vigilante = new Vigilant(userService, vehicleService, invoiceService, rateService);
		
		// act
		vigilante.isAuthorized(StartDateValidate);
		
		// Assert
		Assert.assertTrue(vigilante.isAuthorized(StartDateValidate));
	}
	
	@Test
	public void isSpaceAviableCarTest() {
		
		// Arrange
		
		int spaceAvialbleCar = 20;
		Long countReturn = 5L;
		
		VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder();
		
		Vehicle vehicle = vehicleTestDataBuilder.conType("CARRO").build();
		
		UserService userService = mock(UserService.class);
		VehicleService vehicleService = mock(VehicleService.class);
		InvoiceService invoiceService = mock(InvoiceService.class);
		RateService rateService = mock(RateService.class);
		
		when(invoiceService.getVehicleAndInvoiceStore(vehicle.getType())).thenReturn(countReturn);
		
		Vigilant vigilante = new Vigilant(userService, vehicleService, invoiceService, rateService);
		
		// act
		vigilante.isSpaceAviableCar(vehicle, spaceAvialbleCar);
		
		// Assert
		assertTrue(vigilante.isSpaceAviableCar(vehicle, spaceAvialbleCar));
	}
	
	@Test
	public void isNotSpaceAviableCarTest() {
		
		// Arrange
		
		int spaceAvialbleCar = 20;
		Long countReturn = 30L;
		
		VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder();
		
		Vehicle vehicle = vehicleTestDataBuilder.conType("CARRO").build();
		
		UserService userService = mock(UserService.class);
		VehicleService vehicleService = mock(VehicleService.class);
		InvoiceService invoiceService = mock(InvoiceService.class);
		RateService rateService = mock(RateService.class);
		
		when(invoiceService.getVehicleAndInvoiceStore(vehicle.getType())).thenReturn(countReturn);
		
		Vigilant vigilante = new Vigilant(userService, vehicleService, invoiceService, rateService);
		
		// act
		vigilante.isSpaceAviableCar(vehicle, spaceAvialbleCar);
		
		// Assert
		assertFalse(vigilante.isSpaceAviableCar(vehicle, spaceAvialbleCar));
	}
	
	@Test
	public void isSpaceAviableMotorBykeTest() {
		
		// Arrange
		
		int spaceAvialbleMotorByke = 10;
		Long countReturn = 5L;
		
		VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder();
		
		Vehicle vehicle = vehicleTestDataBuilder.conType("MOTO").build();
		
		UserService userService = mock(UserService.class);
		VehicleService vehicleService = mock(VehicleService.class);
		InvoiceService invoiceService = mock(InvoiceService.class);
		RateService rateService = mock(RateService.class);
		
		when(invoiceService.getVehicleAndInvoiceStore(vehicle.getType())).thenReturn(countReturn);
		
		Vigilant vigilante = new Vigilant(userService, vehicleService, invoiceService, rateService);
		
		// act
		vigilante.isSpaceAviableMotorByke(vehicle, spaceAvialbleMotorByke);
		
		// Assert
		assertTrue(vigilante.isSpaceAviableMotorByke(vehicle, spaceAvialbleMotorByke));
	}
	
	@Test
	public void isNotSpaceAviableMotorBykeTest() {
		
		// Arrange
		
		int spaceAvialbleCar = 20;
		Long countReturn = 30L;
		
		VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder();
		
		Vehicle vehicle = vehicleTestDataBuilder.conType("MOTO").build();
		
		UserService userService = mock(UserService.class);
		VehicleService vehicleService = mock(VehicleService.class);
		InvoiceService invoiceService = mock(InvoiceService.class);
		RateService rateService = mock(RateService.class);
		
		when(invoiceService.getVehicleAndInvoiceStore(vehicle.getType())).thenReturn(countReturn);
		
		Vigilant vigilante = new Vigilant(userService, vehicleService, invoiceService, rateService);
		
		// act
		vigilante.isSpaceAviableMotorByke(vehicle, spaceAvialbleCar);
		
		// Assert
		assertFalse(vigilante.isSpaceAviableMotorByke(vehicle, spaceAvialbleCar));
	}

}


