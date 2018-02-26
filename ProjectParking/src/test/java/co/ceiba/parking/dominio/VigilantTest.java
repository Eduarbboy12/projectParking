package co.ceiba.parking.dominio;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

import co.ceiba.parking.dominio.exception.InvoiceException;
import co.ceiba.parking.dominio.exception.VehicleException;
import co.ceiba.parking.persistence.builder.InvoiceBuilder;
import co.ceiba.parking.persistence.builder.VehicleBuilder;
import co.ceiba.parking.persistence.entity.InvoiceEntity;
import co.ceiba.parking.persistence.entity.VehicleEntity;
import co.ceiba.parking.persistence.repository.jpa.InvoiceRepositoryJPA;
import co.ceiba.parking.persistence.repository.jpa.RateRepositoryJPA;
import co.ceiba.parking.persistence.repository.jpa.UserRepositoryJPA;
import co.ceiba.parking.persistence.repository.jpa.VehicleRepositoryJPA;
import co.ceiba.parking.testdatabuilder.InvoiceTestDataBuilder;
import co.ceiba.parking.testdatabuilder.VehicleTestDataBuilder;

public class VigilantTest {

	@Test
	public void vehicleExistTest() {
		
		// arrange
		VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder();
		
		Vehicle vehicle = vehicleTestDataBuilder.build();
		
		VehicleEntity vehicleEntity = VehicleBuilder.convertirAEntity(vehicle);
		
		VehicleRepositoryJPA vehicleRepositoryJPA = mock(VehicleRepositoryJPA.class);
		InvoiceRepositoryJPA invoiceRepositoryJPA = mock(InvoiceRepositoryJPA.class);
		RateRepositoryJPA rateRepositoryJPA = mock(RateRepositoryJPA.class);
		UserRepositoryJPA userRepositoryJPA = mock(UserRepositoryJPA.class);
		
		when(vehicleRepositoryJPA.findByPlaque(vehicle.getPlaque())).thenReturn(vehicleEntity);
		
		Vigilant vigilant = new Vigilant(vehicleRepositoryJPA, invoiceRepositoryJPA, rateRepositoryJPA, userRepositoryJPA);
		
		// act
		boolean vehicleExist = vigilant.vehicleExist(vehicle.getPlaque());
		
		// Assert
		assertTrue(vehicleExist);
	}
	
	@Test
	public void vehicleNoExistTest() {
		
		// arrange
		VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder();
		
		Vehicle vehicle = vehicleTestDataBuilder.build();
		
		VehicleRepositoryJPA vehicleRepositoryJPA = mock(VehicleRepositoryJPA.class);
		InvoiceRepositoryJPA invoiceRepositoryJPA = mock(InvoiceRepositoryJPA.class);
		RateRepositoryJPA rateRepositoryJPA = mock(RateRepositoryJPA.class);
		UserRepositoryJPA userRepositoryJPA = mock(UserRepositoryJPA.class);
		
		when(vehicleRepositoryJPA.findByPlaque(vehicle.getPlaque())).thenReturn(null);
		
		Vigilant vigilant = new Vigilant(vehicleRepositoryJPA, invoiceRepositoryJPA, rateRepositoryJPA, userRepositoryJPA);
		
		// act
		boolean vehicleExist = vigilant.vehicleExist(vehicle.getPlaque());
		
		// Assert
		assertFalse(vehicleExist);
	}
	
	@Test
	public void isVehicleExistTest() {
		
		// arrange
		VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder();
		
		Vehicle vehicle = vehicleTestDataBuilder.build();
		
		VehicleEntity vehicleEntity = VehicleBuilder.convertirAEntity(vehicle);
		
		VehicleRepositoryJPA vehicleRepositoryJPA = mock(VehicleRepositoryJPA.class);
		InvoiceRepositoryJPA invoiceRepositoryJPA = mock(InvoiceRepositoryJPA.class);
		RateRepositoryJPA rateRepositoryJPA = mock(RateRepositoryJPA.class);
		UserRepositoryJPA userRepositoryJPA = mock(UserRepositoryJPA.class);
		
		when(vehicleRepositoryJPA.findByPlaque(vehicle.getPlaque())).thenReturn(vehicleEntity);
		
		Vigilant vigilant = new Vigilant(vehicleRepositoryJPA, invoiceRepositoryJPA, rateRepositoryJPA, userRepositoryJPA);
		
		// act
		Vehicle vehicleExist = vigilant.isVehicleExist(vehicle.getPlaque());
		
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
		
		VehicleRepositoryJPA vehicleRepositoryJPA = mock(VehicleRepositoryJPA.class);
		InvoiceRepositoryJPA invoiceRepositoryJPA = mock(InvoiceRepositoryJPA.class);
		RateRepositoryJPA rateRepositoryJPA = mock(RateRepositoryJPA.class);
		UserRepositoryJPA userRepositoryJPA = mock(UserRepositoryJPA.class);
		
		when(vehicleRepositoryJPA.findByPlaque(vehicle.getPlaque())).thenReturn(null);
		
		Vigilant vigilant = new Vigilant(vehicleRepositoryJPA, invoiceRepositoryJPA, rateRepositoryJPA, userRepositoryJPA);
		
		// act
		Vehicle vehicleExists = vigilant.isVehicleExist(vehicle.getPlaque());
		
		// Assert		
		assertNull(vehicleExists);
	}
	
	@Test
	public void isNullVehicleNoExistTest() {
		
		// arrange
		VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder();
		
		Vehicle vehicle = vehicleTestDataBuilder.conPlaque(null).build();
		
		VehicleRepositoryJPA vehicleRepositoryJPA = mock(VehicleRepositoryJPA.class);
		InvoiceRepositoryJPA invoiceRepositoryJPA = mock(InvoiceRepositoryJPA.class);
		RateRepositoryJPA rateRepositoryJPA = mock(RateRepositoryJPA.class);
		UserRepositoryJPA userRepositoryJPA = mock(UserRepositoryJPA.class);
		
		when(vehicleRepositoryJPA.findByPlaque(vehicle.getPlaque())).thenReturn(null);
		
		Vigilant vigilant = new Vigilant(vehicleRepositoryJPA, invoiceRepositoryJPA, rateRepositoryJPA, userRepositoryJPA);
		
		// act
		Vehicle vehicleExists = vigilant.isVehicleExist(vehicle.getPlaque());
		
		// Assert		
		assertNull(vehicleExists);
	}
	
	
	
	@Test
	public void isInvoiceExistTest() {
		
		// arrange
		InvoiceTestDataBuilder invoiceTestDataBuilder = new InvoiceTestDataBuilder();
		
		Invoice invoice = invoiceTestDataBuilder.build();
		
		InvoiceEntity invoiceEntity = InvoiceBuilder.convertirAEntity(invoice);
		
		VehicleRepositoryJPA vehicleRepositoryJPA = mock(VehicleRepositoryJPA.class);
		InvoiceRepositoryJPA invoiceRepositoryJPA = mock(InvoiceRepositoryJPA.class);
		RateRepositoryJPA rateRepositoryJPA = mock(RateRepositoryJPA.class);
		UserRepositoryJPA userRepositoryJPA = mock(UserRepositoryJPA.class);
		
		when(invoiceRepositoryJPA.findByVehiclePlaque(invoice.getVehicle().getPlaque())).thenReturn(invoiceEntity);
		
		Vigilant vigilant = new Vigilant(vehicleRepositoryJPA, invoiceRepositoryJPA, rateRepositoryJPA, userRepositoryJPA);
		
		// act
		Invoice invoiceExist = vigilant.isInvoiceExist(invoice.getVehicle());
		
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
		
		VehicleRepositoryJPA vehicleRepositoryJPA = mock(VehicleRepositoryJPA.class);
		InvoiceRepositoryJPA invoiceRepositoryJPA = mock(InvoiceRepositoryJPA.class);
		RateRepositoryJPA rateRepositoryJPA = mock(RateRepositoryJPA.class);
		UserRepositoryJPA userRepositoryJPA = mock(UserRepositoryJPA.class);
		
		when(invoiceRepositoryJPA.findByVehiclePlaque(invoice.getVehicle().getPlaque())).thenReturn(null);
		
		Vigilant vigilant = new Vigilant(vehicleRepositoryJPA, invoiceRepositoryJPA, rateRepositoryJPA, userRepositoryJPA);
		
		// act
		Invoice invoiceExist = vigilant.isInvoiceExist(invoice.getVehicle());
		
		// Assert		
		assertNull(invoiceExist);
	}

	@Test
	public void isOccupedExistTest() {
		
		// arrange
		VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder();
		
		Vehicle vehicle = vehicleTestDataBuilder.conPlaque("ABC123").build();
		
		VehicleEntity vehicleEntity = VehicleBuilder.convertirAEntity(vehicle);
		
		VehicleRepositoryJPA vehicleRepositoryJPA = mock(VehicleRepositoryJPA.class);
		InvoiceRepositoryJPA invoiceRepositoryJPA = mock(InvoiceRepositoryJPA.class);
		RateRepositoryJPA rateRepositoryJPA = mock(RateRepositoryJPA.class);
		UserRepositoryJPA userRepositoryJPA = mock(UserRepositoryJPA.class);
		
		when(vehicleRepositoryJPA.findByPlaque(vehicle.getPlaque())).thenReturn(vehicleEntity);
		
		Vigilant vigilant = new Vigilant(vehicleRepositoryJPA, invoiceRepositoryJPA, rateRepositoryJPA, userRepositoryJPA);
		
		// act
		boolean vehicleIsOccuped = vigilant.isOccuped(vehicle.getPlaque());
		
		// Assert
		assertTrue(vehicleIsOccuped);
	}
	
	@Test
	public void isNotOccupedExistTest() {
		
		// arrange
		VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder();
		
		Vehicle vehicle = vehicleTestDataBuilder.build();
		
		VehicleRepositoryJPA vehicleRepositoryJPA = mock(VehicleRepositoryJPA.class);
		InvoiceRepositoryJPA invoiceRepositoryJPA = mock(InvoiceRepositoryJPA.class);
		RateRepositoryJPA rateRepositoryJPA = mock(RateRepositoryJPA.class);
		UserRepositoryJPA userRepositoryJPA = mock(UserRepositoryJPA.class);
		
		when(vehicleRepositoryJPA.findByPlaque(vehicle.getPlaque())).thenReturn(null);
		
		Vigilant vigilant = new Vigilant(vehicleRepositoryJPA, invoiceRepositoryJPA, rateRepositoryJPA, userRepositoryJPA);
		
		// act
		boolean vehicleIsOccuped = vigilant.isOccuped(vehicle.getPlaque());
		
		// Assert
		assertFalse(vehicleIsOccuped);
	}
	
	@Test
	public void inputVehicleTest() {
		
		// arrange		
		InvoiceTestDataBuilder invoiceTestDataBuilder = new InvoiceTestDataBuilder();
		
		Invoice invoice = invoiceTestDataBuilder.build();
		
		VehicleRepositoryJPA vehicleRepositoryJPA = mock(VehicleRepositoryJPA.class);
		InvoiceRepositoryJPA invoiceRepositoryJPA = mock(InvoiceRepositoryJPA.class);
		RateRepositoryJPA rateRepositoryJPA = mock(RateRepositoryJPA.class);
		UserRepositoryJPA userRepositoryJPA = mock(UserRepositoryJPA.class);
		
		Vigilant vigilant = new Vigilant(vehicleRepositoryJPA, invoiceRepositoryJPA, rateRepositoryJPA, userRepositoryJPA);
		
		// act
		try {
			vigilant.inputVehicle(invoice.getVehicle());
		} catch (VehicleException ve) {
			Assert.assertEquals(Vigilant.CAR_NOT_IS_AUTORIZED_BY_PLACA, ve.getMessage());
		}
			
	}
	
	@Test
	public void inputVehicleNotTest() {
		
		// arrange
		
		InvoiceTestDataBuilder invoiceTestDataBuilder = new InvoiceTestDataBuilder();
		
		Invoice invoice = invoiceTestDataBuilder.build();
		
		VehicleRepositoryJPA vehicleRepositoryJPA = mock(VehicleRepositoryJPA.class);
		InvoiceRepositoryJPA invoiceRepositoryJPA = mock(InvoiceRepositoryJPA.class);
		RateRepositoryJPA rateRepositoryJPA = mock(RateRepositoryJPA.class);
		UserRepositoryJPA userRepositoryJPA = mock(UserRepositoryJPA.class);
		
		Vigilant vigilant = new Vigilant(vehicleRepositoryJPA, invoiceRepositoryJPA, rateRepositoryJPA, userRepositoryJPA);
		
		// act
		try {
			vigilant.inputVehicle(invoice.getVehicle());
		} catch (VehicleException e) {
			assertEquals(Vigilant.CAR_NOT_IS_AUTORIZED_BY_PLACA, e.getMessage());
		}
	}
	
	
	@Test
	public void isNotAuthorizedSundayTest() {
		
		// Arrange
		LocalDateTime StartDateValidate = LocalDateTime.of(2018, Calendar.FEBRUARY, 28, 10, 10);
		
		VehicleRepositoryJPA vehicleRepositoryJPA = mock(VehicleRepositoryJPA.class);
		InvoiceRepositoryJPA invoiceRepositoryJPA = mock(InvoiceRepositoryJPA.class);
		RateRepositoryJPA rateRepositoryJPA = mock(RateRepositoryJPA.class);
		UserRepositoryJPA userRepositoryJPA = mock(UserRepositoryJPA.class);
		
		Vigilant vigilant = new Vigilant(vehicleRepositoryJPA, invoiceRepositoryJPA, rateRepositoryJPA, userRepositoryJPA);
		
		// act
		vigilant.isAuthorized(StartDateValidate);
		
		// Assert
		Assert.assertFalse(vigilant.isAuthorized(StartDateValidate));
	}
	
	@Test
	public void isNotAuthorizedMondayTest() {
		
		// Arrange
		LocalDateTime StartDateValidate = LocalDateTime.of(2018, Calendar.FEBRUARY, 29, 10, 10);
		
		VehicleRepositoryJPA vehicleRepositoryJPA = mock(VehicleRepositoryJPA.class);
		InvoiceRepositoryJPA invoiceRepositoryJPA = mock(InvoiceRepositoryJPA.class);
		RateRepositoryJPA rateRepositoryJPA = mock(RateRepositoryJPA.class);
		UserRepositoryJPA userRepositoryJPA = mock(UserRepositoryJPA.class);
		
		Vigilant vigilant = new Vigilant(vehicleRepositoryJPA, invoiceRepositoryJPA, rateRepositoryJPA, userRepositoryJPA);
		
		// act
		vigilant.isAuthorized(StartDateValidate);
		
		// Assert
		Assert.assertFalse(vigilant.isAuthorized(StartDateValidate));
	}
	
	@Test
	public void isAuthorizedTest() {
		
		// Arrange
		
		LocalDateTime StartDateValidate = LocalDateTime.of(2018, Calendar.FEBRUARY, 20, 10, 10);
		
		VehicleRepositoryJPA vehicleRepositoryJPA = mock(VehicleRepositoryJPA.class);
		InvoiceRepositoryJPA invoiceRepositoryJPA = mock(InvoiceRepositoryJPA.class);
		RateRepositoryJPA rateRepositoryJPA = mock(RateRepositoryJPA.class);
		UserRepositoryJPA userRepositoryJPA = mock(UserRepositoryJPA.class);
		
		Vigilant vigilant = new Vigilant(vehicleRepositoryJPA, invoiceRepositoryJPA, rateRepositoryJPA, userRepositoryJPA);
		
		// act
		vigilant.isAuthorized(StartDateValidate);
		
		// Assert
		Assert.assertTrue(vigilant.isAuthorized(StartDateValidate));
	}
	
	@Test
	public void isSpaceAviableCarTest() {
		
		// Arrange
		
		int spaceAvialbleCar = 20;
		Long countReturn = 5L;
		
		VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder();
		
		Vehicle vehicle = vehicleTestDataBuilder.conType("CARRO").build();
		
		VehicleRepositoryJPA vehicleRepositoryJPA = mock(VehicleRepositoryJPA.class);
		InvoiceRepositoryJPA invoiceRepositoryJPA = mock(InvoiceRepositoryJPA.class);
		RateRepositoryJPA rateRepositoryJPA = mock(RateRepositoryJPA.class);
		UserRepositoryJPA userRepositoryJPA = mock(UserRepositoryJPA.class);
		
		when(invoiceRepositoryJPA.countByVehicleType(vehicle.getType())).thenReturn(countReturn);
		
		Vigilant vigilant = new Vigilant(vehicleRepositoryJPA, invoiceRepositoryJPA, rateRepositoryJPA, userRepositoryJPA);
		
		// act
		vigilant.isSpaceAviableCar(vehicle, spaceAvialbleCar);
		
		// Assert
		assertTrue(vigilant.isSpaceAviableCar(vehicle, spaceAvialbleCar));
	}
	
	@Test
	public void isNotSpaceAviableCarTest() {
		
		// Arrange
		
		int spaceAvialbleCar = 20;
		Long countReturn = 30L;
		
		VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder();
		
		Vehicle vehicle = vehicleTestDataBuilder.conType("CARRO").build();
		
		VehicleRepositoryJPA vehicleRepositoryJPA = mock(VehicleRepositoryJPA.class);
		InvoiceRepositoryJPA invoiceRepositoryJPA = mock(InvoiceRepositoryJPA.class);
		RateRepositoryJPA rateRepositoryJPA = mock(RateRepositoryJPA.class);
		UserRepositoryJPA userRepositoryJPA = mock(UserRepositoryJPA.class);
		
		when(invoiceRepositoryJPA.countByVehicleType(vehicle.getType())).thenReturn(countReturn);
		
		Vigilant vigilant = new Vigilant(vehicleRepositoryJPA, invoiceRepositoryJPA, rateRepositoryJPA, userRepositoryJPA);
		
		// act
		vigilant.isSpaceAviableCar(vehicle, spaceAvialbleCar);
		
		// Assert
		assertFalse(vigilant.isSpaceAviableCar(vehicle, spaceAvialbleCar));
	}
	
	@Test
	public void isNullNotSpaceAviableCarTest() {
		
		// Arrange
		
		int spaceAvialbleCar = 20;
		Long countReturn = 30L;
		
		VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder();
		
		Vehicle vehicle = vehicleTestDataBuilder.conType(null).build();
		
		VehicleRepositoryJPA vehicleRepositoryJPA = mock(VehicleRepositoryJPA.class);
		InvoiceRepositoryJPA invoiceRepositoryJPA = mock(InvoiceRepositoryJPA.class);
		RateRepositoryJPA rateRepositoryJPA = mock(RateRepositoryJPA.class);
		UserRepositoryJPA userRepositoryJPA = mock(UserRepositoryJPA.class);
		
		when(invoiceRepositoryJPA.countByVehicleType(vehicle.getType())).thenReturn(countReturn);
		
		Vigilant vigilant = new Vigilant(vehicleRepositoryJPA, invoiceRepositoryJPA, rateRepositoryJPA, userRepositoryJPA);
		
		// act
		vigilant.isSpaceAviableCar(vehicle, spaceAvialbleCar);
		
		// Assert
		assertFalse(vigilant.isSpaceAviableCar(vehicle, spaceAvialbleCar));
	}
	
	@Test
	public void isNullSpaceAviableCarTest() {
		
		// Arrange
		
		int spaceAvialbleCar = 20;
		Long countReturn = 30L;
		
		Vehicle vehicle = null;
		
		VehicleRepositoryJPA vehicleRepositoryJPA = mock(VehicleRepositoryJPA.class);
		InvoiceRepositoryJPA invoiceRepositoryJPA = mock(InvoiceRepositoryJPA.class);
		RateRepositoryJPA rateRepositoryJPA = mock(RateRepositoryJPA.class);
		UserRepositoryJPA userRepositoryJPA = mock(UserRepositoryJPA.class);
		
		when(invoiceRepositoryJPA.countByVehicleType("CARRO")).thenReturn(countReturn);
		
		Vigilant vigilant = new Vigilant(vehicleRepositoryJPA, invoiceRepositoryJPA, rateRepositoryJPA, userRepositoryJPA);
		
		// act
		vigilant.isSpaceAviableCar(vehicle, spaceAvialbleCar);
		
		// Assert
		assertFalse(vigilant.isSpaceAviableCar(vehicle, spaceAvialbleCar));
	}
	
	@Test
	public void isSpaceAviableMotorBykeTest() {
		
		// Arrange
		
		int spaceAvialbleMotorByke = 10;
		Long countReturn = 5L;
		
		VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder();
		
		Vehicle vehicle = vehicleTestDataBuilder.conType("MOTO").build();
		
		VehicleRepositoryJPA vehicleRepositoryJPA = mock(VehicleRepositoryJPA.class);
		InvoiceRepositoryJPA invoiceRepositoryJPA = mock(InvoiceRepositoryJPA.class);
		RateRepositoryJPA rateRepositoryJPA = mock(RateRepositoryJPA.class);
		UserRepositoryJPA userRepositoryJPA = mock(UserRepositoryJPA.class);
		
		when(invoiceRepositoryJPA.countByVehicleType(vehicle.getType())).thenReturn(countReturn);
		
		Vigilant vigilant = new Vigilant(vehicleRepositoryJPA, invoiceRepositoryJPA, rateRepositoryJPA, userRepositoryJPA);
		
		// act
		vigilant.isSpaceAviableMotorByke(vehicle, spaceAvialbleMotorByke);
		
		// Assert
		assertTrue(vigilant.isSpaceAviableMotorByke(vehicle, spaceAvialbleMotorByke));
	}
	
	@Test
	public void isNotSpaceAviableMotorBykeTest() {
		
		// Arrange
		
		int spaceAvialbleCar = 20;
		Long countReturn = 30L;
		
		VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder();
		
		Vehicle vehicle = vehicleTestDataBuilder.conType("MOTO").build();
		
		VehicleRepositoryJPA vehicleRepositoryJPA = mock(VehicleRepositoryJPA.class);
		InvoiceRepositoryJPA invoiceRepositoryJPA = mock(InvoiceRepositoryJPA.class);
		RateRepositoryJPA rateRepositoryJPA = mock(RateRepositoryJPA.class);
		UserRepositoryJPA userRepositoryJPA = mock(UserRepositoryJPA.class);
		
		when(invoiceRepositoryJPA.countByVehicleType(vehicle.getType())).thenReturn(countReturn);
		
		Vigilant vigilant = new Vigilant(vehicleRepositoryJPA, invoiceRepositoryJPA, rateRepositoryJPA, userRepositoryJPA);
		
		// act
		vigilant.isSpaceAviableMotorByke(vehicle, spaceAvialbleCar);
		
		// Assert
		assertFalse(vigilant.isSpaceAviableMotorByke(vehicle, spaceAvialbleCar));
	}
	
	@Test
	public void isNullNotSpaceAviableMotorBykeTest() {
		
		// Arrange
		
		int spaceAvialbleCar = 20;
		Long countReturn = 5L;
		
		Vehicle vehicle = null;
		
		VehicleRepositoryJPA vehicleRepositoryJPA = mock(VehicleRepositoryJPA.class);
		InvoiceRepositoryJPA invoiceRepositoryJPA = mock(InvoiceRepositoryJPA.class);
		RateRepositoryJPA rateRepositoryJPA = mock(RateRepositoryJPA.class);
		UserRepositoryJPA userRepositoryJPA = mock(UserRepositoryJPA.class);
		
		when(invoiceRepositoryJPA.countByVehicleType("CARRO")).thenReturn(countReturn);
		
		Vigilant vigilant = new Vigilant(vehicleRepositoryJPA, invoiceRepositoryJPA, rateRepositoryJPA, userRepositoryJPA);
		
		// act
		vigilant.isSpaceAviableMotorByke(vehicle, spaceAvialbleCar);
		
		// Assert
		assertFalse(vigilant.isSpaceAviableMotorByke(vehicle, spaceAvialbleCar));
	}
	
	@Test
	public void isNullSpaceAviableMotorBykeTest() {
		
		// Arrange
		
		int spaceAvialbleCar = 20;
		
		VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder();
		
		Vehicle vehicle = vehicleTestDataBuilder.conType(null).build();
		
		VehicleRepositoryJPA vehicleRepositoryJPA = mock(VehicleRepositoryJPA.class);
		InvoiceRepositoryJPA invoiceRepositoryJPA = mock(InvoiceRepositoryJPA.class);
		RateRepositoryJPA rateRepositoryJPA = mock(RateRepositoryJPA.class);
		UserRepositoryJPA userRepositoryJPA = mock(UserRepositoryJPA.class);
		
		when(invoiceRepositoryJPA.countByVehicleType(vehicle.getType())).thenReturn(null);
		
		Vigilant vigilant = new Vigilant(vehicleRepositoryJPA, invoiceRepositoryJPA, rateRepositoryJPA, userRepositoryJPA);
		
		// act
		vigilant.isSpaceAviableMotorByke(vehicle, spaceAvialbleCar);
		
		// Assert
		assertFalse(vigilant.isSpaceAviableMotorByke(vehicle, spaceAvialbleCar));
	}
	
	@Test
	public void spaceAvailableCarTest() {
		
		// Arrange
		VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder();
		
		Vehicle vehicle = vehicleTestDataBuilder.conType("MOTO").build();
		
		VehicleRepositoryJPA vehicleRepositoryJPA = mock(VehicleRepositoryJPA.class);
		InvoiceRepositoryJPA invoiceRepositoryJPA = mock(InvoiceRepositoryJPA.class);
		RateRepositoryJPA rateRepositoryJPA = mock(RateRepositoryJPA.class);
		UserRepositoryJPA userRepositoryJPA = mock(UserRepositoryJPA.class);
		
		Vigilant vigilant = new Vigilant(vehicleRepositoryJPA, invoiceRepositoryJPA, rateRepositoryJPA, userRepositoryJPA);
		
		// act
		vigilant.spaceAvailable(vehicle);
		
		// Assert
		assertTrue(vigilant.spaceAvailable(vehicle));
		
	}
	
	@Test
	public void notSpaceAvailableCarTest() {
		
		// Arrange
		VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder();
		
		Vehicle vehicle = vehicleTestDataBuilder.build();
		
		VehicleRepositoryJPA vehicleRepositoryJPA = mock(VehicleRepositoryJPA.class);
		InvoiceRepositoryJPA invoiceRepositoryJPA = mock(InvoiceRepositoryJPA.class);
		RateRepositoryJPA rateRepositoryJPA = mock(RateRepositoryJPA.class);
		UserRepositoryJPA userRepositoryJPA = mock(UserRepositoryJPA.class);
		
		Vigilant vigilant = new Vigilant(vehicleRepositoryJPA, invoiceRepositoryJPA, rateRepositoryJPA, userRepositoryJPA);
		
		// act
		vigilant.spaceAvailable(vehicle);
		
		// Assert
		assertTrue(vigilant.spaceAvailable(vehicle));
		
	}
	
	@Test
	public void isSpaceAvailableTest() {
		
		//Arrange
		VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder();
		
		Vehicle vehicle = vehicleTestDataBuilder.conType(null).build();
		
		VehicleRepositoryJPA vehicleRepositoryJPA = mock(VehicleRepositoryJPA.class);
		InvoiceRepositoryJPA invoiceRepositoryJPA = mock(InvoiceRepositoryJPA.class);
		RateRepositoryJPA rateRepositoryJPA = mock(RateRepositoryJPA.class);
		UserRepositoryJPA userRepositoryJPA = mock(UserRepositoryJPA.class);
		
		Vigilant vigilant = new Vigilant(vehicleRepositoryJPA, invoiceRepositoryJPA, rateRepositoryJPA, userRepositoryJPA);
		
		// act
		try {
			vigilant.spaceAvailable(vehicle);
		} catch (VehicleException e) {
			// Assert
			assertEquals(Vigilant.PLAQUE_NOT_STORE, e.getMessage());
		}
		
	}
	
	@Test
	public void isNullSpaceAvailableTest() {
		
		//Arrange		
		Vehicle vehicle = null;
		
		VehicleRepositoryJPA vehicleRepositoryJPA = mock(VehicleRepositoryJPA.class);
		InvoiceRepositoryJPA invoiceRepositoryJPA = mock(InvoiceRepositoryJPA.class);
		RateRepositoryJPA rateRepositoryJPA = mock(RateRepositoryJPA.class);
		UserRepositoryJPA userRepositoryJPA = mock(UserRepositoryJPA.class);
		
		Vigilant vigilant = new Vigilant(vehicleRepositoryJPA, invoiceRepositoryJPA, rateRepositoryJPA, userRepositoryJPA);
		
		// act
		try {
			vigilant.spaceAvailable(vehicle);
		} catch (VehicleException ve) {
			
			// Assert
			Assert.assertEquals(Vigilant.PLAQUE_NOT_STORE, ve.getMessage());
		}
		
	}
	
	@Test
	public void isInputVehicleTest() {
		// arrange		
		VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder();
		
		Vehicle vehicle = vehicleTestDataBuilder.conPlaque("ZZA123").build();
		
		VehicleRepositoryJPA vehicleRepositoryJPA = mock(VehicleRepositoryJPA.class);
		InvoiceRepositoryJPA invoiceRepositoryJPA = mock(InvoiceRepositoryJPA.class);
		RateRepositoryJPA rateRepositoryJPA = mock(RateRepositoryJPA.class);
		UserRepositoryJPA userRepositoryJPA = mock(UserRepositoryJPA.class);
		
		//when(invoiceRepositoryJPA.countByVehicleType(vehicle.getType())).thenReturn(null);
		
		Vigilant vigilant = new Vigilant(vehicleRepositoryJPA, invoiceRepositoryJPA, rateRepositoryJPA, userRepositoryJPA);
		
		// act
		Vehicle vehicleTest = vigilant.inputVehicle(vehicle);
		
		assertEquals(vehicleTest.getType(), vehicle.getType());
		
		
	}
	
	@Test
	public void isNullOutputVehicle() {
		//Arrange		
		VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder();
		
		Vehicle vehicle = vehicleTestDataBuilder.conPlaque(null).build();
		
		VehicleRepositoryJPA vehicleRepositoryJPA = mock(VehicleRepositoryJPA.class);
		InvoiceRepositoryJPA invoiceRepositoryJPA = mock(InvoiceRepositoryJPA.class);
		RateRepositoryJPA rateRepositoryJPA = mock(RateRepositoryJPA.class);
		UserRepositoryJPA userRepositoryJPA = mock(UserRepositoryJPA.class);
		
		Vigilant vigilant = new Vigilant(vehicleRepositoryJPA, invoiceRepositoryJPA, rateRepositoryJPA, userRepositoryJPA);
		
		// act
		try {
			vigilant.outputVehicle(vehicle.getPlaque());
		} catch (InvoiceException ve) {
			
			// Assert
			Assert.assertEquals(Vigilant.PLAQUE_NOT_STORE, ve.getMessage());
		}
	}
	
	@Test
	public void isOutputVehicle() {
		//Arrange		
		InvoiceTestDataBuilder invoiceTestDataBuilder = new InvoiceTestDataBuilder();
		
		Invoice invoice = invoiceTestDataBuilder.build();
		
		VehicleRepositoryJPA vehicleRepositoryJPA = mock(VehicleRepositoryJPA.class);
		InvoiceRepositoryJPA invoiceRepositoryJPA = mock(InvoiceRepositoryJPA.class);
		RateRepositoryJPA rateRepositoryJPA = mock(RateRepositoryJPA.class);
		UserRepositoryJPA userRepositoryJPA = mock(UserRepositoryJPA.class);
		
		Vigilant vigilant = new Vigilant(vehicleRepositoryJPA, invoiceRepositoryJPA, rateRepositoryJPA, userRepositoryJPA);
		
		// act
		try {
			Invoice invoiceTest = vigilant.outputVehicle(invoice.getVehicle().getPlaque());
		} catch (VehicleException e) {
			// Assert
			Assert.assertEquals(Vigilant.PLAQUE_NOT_STORE , e.getMessage());
		}
	}
	
	@Test
	public void isOtherOutputVehicle() {
		//Arrange		
		InvoiceTestDataBuilder invoiceTestDataBuilder = new InvoiceTestDataBuilder();
		VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder();
		
		Vehicle vehicle = vehicleTestDataBuilder.conPlaque("MJM160").build();
		Invoice invoice = invoiceTestDataBuilder.conVehicle(vehicle).conDateOutput(null).build();
		
		InvoiceEntity invoiceEntity = InvoiceBuilder.convertirAEntity(invoice);
		
		VehicleRepositoryJPA vehicleRepositoryJPA = mock(VehicleRepositoryJPA.class);
		InvoiceRepositoryJPA invoiceRepositoryJPA = mock(InvoiceRepositoryJPA.class);
		RateRepositoryJPA rateRepositoryJPA = mock(RateRepositoryJPA.class);
		UserRepositoryJPA userRepositoryJPA = mock(UserRepositoryJPA.class);
		
		when(invoiceRepositoryJPA.findByVehiclePlaque(invoice.getVehicle().getPlaque())).thenReturn(invoiceEntity);
		
		Vigilant vigilant = new Vigilant(vehicleRepositoryJPA, invoiceRepositoryJPA, rateRepositoryJPA, userRepositoryJPA);
		
		// act
		try {
			Invoice invoiceTest = vigilant.outputVehicle(invoice.getVehicle().getPlaque());
		} catch (VehicleException e) {
			// Assert
			Assert.assertEquals(Vigilant.PLAQUE_NOT_STORE , e.getMessage());
		}
	}
	
	@Test
	public void isOutputVehicleMotorByke() {
		//Arrange		
		InvoiceTestDataBuilder invoiceTestDataBuilder = new InvoiceTestDataBuilder();
		VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder();
		
		Vehicle vehicle = vehicleTestDataBuilder.conPlaque("MOT123").conCylinder("1000").conType("MOTO").build();
		Invoice invoice = invoiceTestDataBuilder.conVehicle(vehicle).conDateOutput(null).build();
		
		InvoiceEntity invoiceEntity = InvoiceBuilder.convertirAEntity(invoice);
		
		VehicleRepositoryJPA vehicleRepositoryJPA = mock(VehicleRepositoryJPA.class);
		InvoiceRepositoryJPA invoiceRepositoryJPA = mock(InvoiceRepositoryJPA.class);
		RateRepositoryJPA rateRepositoryJPA = mock(RateRepositoryJPA.class);
		UserRepositoryJPA userRepositoryJPA = mock(UserRepositoryJPA.class);
		
		when(invoiceRepositoryJPA.findByVehiclePlaque(invoice.getVehicle().getPlaque())).thenReturn(invoiceEntity);
		
		Vigilant vigilant = new Vigilant(vehicleRepositoryJPA, invoiceRepositoryJPA, rateRepositoryJPA, userRepositoryJPA);
		
		// act
		try {
			Invoice invoiceTest = vigilant.outputVehicle(invoice.getVehicle().getPlaque());
		} catch (VehicleException e) {
			// Assert
			Assert.assertEquals(Vigilant.PLAQUE_NOT_STORE , e.getMessage());
		}
	}

}


