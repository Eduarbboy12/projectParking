package co.ceiba.parking.dominio;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import co.ceiba.parking.persistence.builder.VehicleBuilder;
import co.ceiba.parking.persistence.entity.VehicleEntity;
import co.ceiba.parking.persistence.repository.jpa.InvoiceRepositoryJPA;
import co.ceiba.parking.persistence.repository.jpa.RateRepositoryJPA;
import co.ceiba.parking.persistence.repository.jpa.UserRepositoryJPA;
import co.ceiba.parking.persistence.repository.jpa.VehicleRepositoryJPA;
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
//	
//	@Test
//	public void vehicleNoExistTest() {
//		
//		// arrange
//		VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder();
//		
//		Vehicle vehicle = vehicleTestDataBuilder.build();
//		
//		VehicleRepository vehicleRepository = mock(VehicleRepository.class);
//		InvoiceRepository invoiceRepository = mock(InvoiceRepository.class);
//		RateRepository rateRepository = mock(RateRepository.class);
//		UserRepository userRepository = mock(UserRepository.class);
//		
//		when(vehicleRepository.getByPlaque(vehicle.getPlaque())).thenReturn(null);
//		
//		Vigilant vigilante = new Vigilant(vehicleRepository, invoiceRepository, rateRepository, userRepository);
//		
//		// act
//		boolean vehicleExist = vigilante.vehicleExist(vehicle.getPlaque());
//		
//		// Assert
//		assertFalse(vehicleExist);
//	}
//	
//	@Test
//	public void isVehicleExistTest() {
//		
//		// arrange
//		VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder();
//		
//		Vehicle vehicle = vehicleTestDataBuilder.build();
//		
//		VehicleRepository vehicleRepository = mock(VehicleRepository.class);
//		InvoiceRepository invoiceRepository = mock(InvoiceRepository.class);
//		RateRepository rateRepository = mock(RateRepository.class);
//		UserRepository userRepository = mock(UserRepository.class);
//		
//		when(vehicleRepository.getByPlaque(vehicle.getPlaque())).thenReturn(vehicle);
//		
//		Vigilant vigilante = new Vigilant(vehicleRepository, invoiceRepository, rateRepository, userRepository);
//		
//		// act
//		Vehicle vehicleExist = vigilante.isVehicleExist(vehicle.getPlaque());
//		
//		// Assert
//		assertEquals(vehicleExist.getType(), vehicle.getType());
//		assertEquals(vehicleExist.getPlaque(), vehicle.getPlaque());
//		assertEquals(vehicleExist.getDocument(), vehicle.getDocument());
//		assertEquals(vehicleExist.getCylinder(), vehicle.getCylinder());
//	}
//	
//	@Test
//	public void isVehicleNoExistTest() {
//		
//		// arrange
//		VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder();
//		
//		Vehicle vehicle = vehicleTestDataBuilder.build();
//		
//		VehicleRepository vehicleRepository = mock(VehicleRepository.class);
//		InvoiceRepository invoiceRepository = mock(InvoiceRepository.class);
//		RateRepository rateRepository = mock(RateRepository.class);
//		UserRepository userRepository = mock(UserRepository.class);
//		
//		when(vehicleRepository.getByPlaque(vehicle.getPlaque())).thenReturn(null);
//		
//		Vigilant vigilante = new Vigilant(vehicleRepository, invoiceRepository, rateRepository, userRepository);
//		
//		// act
//		Vehicle vehicleExists = vigilante.isVehicleExist(vehicle.getPlaque());
//		
//		// Assert		
//		assertNull(vehicleExists);
//	}
//	
//	@Test
//	public void isInvoiceExistTest() {
//		
//		// arrange
//		InvoiceTestDataBuilder invoiceTestDataBuilder = new InvoiceTestDataBuilder();
//		
//		Invoice invoice = invoiceTestDataBuilder.build();
//		
//		VehicleRepository vehicleRepository = mock(VehicleRepository.class);
//		InvoiceRepository invoiceRepository = mock(InvoiceRepository.class);
//		RateRepository rateRepository = mock(RateRepository.class);
//		UserRepository userRepository = mock(UserRepository.class);
//		
//		when(invoiceRepository.getByVehiculo(invoice.getVehicle())).thenReturn(invoice);
//		
//		Vigilant vigilante = new Vigilant(vehicleRepository, invoiceRepository, rateRepository, userRepository);
//		
//		// act
//		Invoice invoiceExist = vigilante.isInvoiceExist(invoice.getVehicle());
//		
//		// Assert
//		assertEquals(invoiceExist.getVehicle().getType(), invoice.getVehicle().getType());
//		assertEquals(invoiceExist.getVehicle().getPlaque(), invoice.getVehicle().getPlaque());
//		assertEquals(invoiceExist.getVehicle().getDocument(), invoice.getVehicle().getDocument());
//		assertEquals(invoiceExist.getVehicle().getCylinder(), invoice.getVehicle().getCylinder());
//	}
//	
//	@Test
//	public void isInvoiceNoExistTest() {
//		
//		// arrange
//		InvoiceTestDataBuilder invoiceTestDataBuilder = new InvoiceTestDataBuilder();
//		
//		Invoice invoice = invoiceTestDataBuilder.build();
//		
//		VehicleRepository vehicleRepository = mock(VehicleRepository.class);
//		InvoiceRepository invoiceRepository = mock(InvoiceRepository.class);
//		RateRepository rateRepository = mock(RateRepository.class);
//		UserRepository userRepository = mock(UserRepository.class);
//		
//		when(invoiceRepository.getByVehiculo(invoice.getVehicle())).thenReturn(null);
//		
//		Vigilant vigilante = new Vigilant(vehicleRepository, invoiceRepository, rateRepository, userRepository);
//		
//		// act
//		Invoice invoiceExist = vigilante.isInvoiceExist(invoice.getVehicle());
//		
//		// Assert		
//		assertNull(invoiceExist);
//	}
//
//	@Test
//	public void isOccupedExistTest() {
//		
//		// arrange
//		VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder();
//		
//		Vehicle vehicle = vehicleTestDataBuilder.conPlaque("ABC123").build();
//		
//		VehicleRepository vehicleRepository = mock(VehicleRepository.class);
//		InvoiceRepository invoiceRepository = mock(InvoiceRepository.class);
//		RateRepository rateRepository = mock(RateRepository.class);
//		UserRepository userRepository = mock(UserRepository.class);
//		
//		when(vehicleRepository.getByPlaque(vehicle.getPlaque())).thenReturn(vehicle);
//		
//		Vigilant vigilante = new Vigilant(vehicleRepository, invoiceRepository, rateRepository, userRepository);
//		
//		// act
//		boolean vehicleIsOccuped = vigilante.isOccuped(vehicle.getPlaque());
//		
//		// Assert
//		assertTrue(vehicleIsOccuped);
//	}
//	
//	@Test
//	public void isNotOccupedExistTest() {
//		
//		// arrange
//		VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder();
//		
//		Vehicle vehicle = vehicleTestDataBuilder.build();
//		
//		VehicleRepository vehicleRepository = mock(VehicleRepository.class);
//		InvoiceRepository invoiceRepository = mock(InvoiceRepository.class);
//		RateRepository rateRepository = mock(RateRepository.class);
//		UserRepository userRepository = mock(UserRepository.class);
//		
//		when(vehicleRepository.getByPlaque(vehicle.getPlaque())).thenReturn(null);
//		
//		Vigilant vigilante = new Vigilant(vehicleRepository, invoiceRepository, rateRepository, userRepository);
//		
//		// act
//		boolean vehicleIsOccuped = vigilante.isOccuped(vehicle.getPlaque());
//		
//		// Assert
//		assertFalse(vehicleIsOccuped);
//	}
//	
//	@Test
//	public void inputVehicleTest() {
//		
//		// arrange
//		LocalDateTime StartDateValidate = LocalDateTime.of(2018, Calendar.FEBRUARY, 20, 10, 10);
//		
//		InvoiceTestDataBuilder invoiceTestDataBuilder = new InvoiceTestDataBuilder();
//		
//		Invoice invoice = invoiceTestDataBuilder.build();
//		
//		VehicleRepository vehicleRepository = mock(VehicleRepository.class);
//		InvoiceRepository invoiceRepository = mock(InvoiceRepository.class);
//		RateRepository rateRepository = mock(RateRepository.class);
//		UserRepository userRepository = mock(UserRepository.class);
//		
//		Vigilant vigilante = new Vigilant(vehicleRepository, invoiceRepository, rateRepository, userRepository);
//		
//		// act
//		vigilante.inputVehicle(invoice.getVehicle());
//		
//		// Assert
//		Assert.assertFalse(vigilante.isOccuped(invoice.getVehicle().getPlaque()));
//		Assert.assertTrue(vigilante.isAuthorized(StartDateValidate));
//		Assert.assertTrue(vigilante.spaceAvailable(invoice.getVehicle()));		
//	}
//	
//	@Test
//	public void inputVehicleNotTest() {
//		
//		// arrange
//		LocalDateTime StartDateValidate = LocalDateTime.of(2018, Calendar.FEBRUARY, 28, 10, 10);
//		
//		InvoiceTestDataBuilder invoiceTestDataBuilder = new InvoiceTestDataBuilder();
//		
//		Invoice invoice = invoiceTestDataBuilder.build();
//		
//		VehicleRepository vehicleRepository = mock(VehicleRepository.class);
//		InvoiceRepository invoiceRepository = mock(InvoiceRepository.class);
//		RateRepository rateRepository = mock(RateRepository.class);
//		UserRepository userRepository = mock(UserRepository.class);
//		
//		Vigilant vigilante = new Vigilant(vehicleRepository, invoiceRepository, rateRepository, userRepository);
//		
//		// act
//		vigilante.inputVehicle(invoice.getVehicle());
//		
//		// Assert
//		Assert.assertFalse(vigilante.isOccuped(invoice.getVehicle().getPlaque()));
//		Assert.assertFalse(vigilante.isAuthorized(StartDateValidate));	
//	}
//	
//	
//	@Test
//	public void isNotAuthorizedTest() {
//		
//		// Arrange
//		LocalDateTime StartDateValidate = LocalDateTime.of(2018, Calendar.FEBRUARY, 28, 10, 10);
//		
//		VehicleRepository vehicleRepository = mock(VehicleRepository.class);
//		InvoiceRepository invoiceRepository = mock(InvoiceRepository.class);
//		RateRepository rateRepository = mock(RateRepository.class);
//		UserRepository userRepository = mock(UserRepository.class);
//		
//		Vigilant vigilante = new Vigilant(vehicleRepository, invoiceRepository, rateRepository, userRepository);
//		
//		// act
//		vigilante.isAuthorized(StartDateValidate);
//		
//		// Assert
//		Assert.assertFalse(vigilante.isAuthorized(StartDateValidate));
//	}
//	
//	@Test
//	public void isAuthorizedTest() {
//		
//		// Arrange
//		
//		LocalDateTime StartDateValidate = LocalDateTime.of(2018, Calendar.FEBRUARY, 20, 10, 10);
//		
//		VehicleRepository vehicleRepository = mock(VehicleRepository.class);
//		InvoiceRepository invoiceRepository = mock(InvoiceRepository.class);
//		RateRepository rateRepository = mock(RateRepository.class);
//		UserRepository userRepository = mock(UserRepository.class);
//		
//		Vigilant vigilante = new Vigilant(vehicleRepository, invoiceRepository, rateRepository, userRepository);
//		
//		// act
//		vigilante.isAuthorized(StartDateValidate);
//		
//		// Assert
//		Assert.assertTrue(vigilante.isAuthorized(StartDateValidate));
//	}
//	
//	@Test
//	public void isSpaceAviableCarTest() {
//		
//		// Arrange
//		
//		int spaceAvialbleCar = 20;
//		Long countReturn = 5L;
//		
//		VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder();
//		
//		Vehicle vehicle = vehicleTestDataBuilder.conType("CARRO").build();
//		
//		VehicleRepository vehicleRepository = mock(VehicleRepository.class);
//		InvoiceRepository invoiceRepository = mock(InvoiceRepository.class);
//		RateRepository rateRepository = mock(RateRepository.class);
//		UserRepository userRepository = mock(UserRepository.class);
//		
//		when(invoiceRepository.getByVehicleAndInvoiceStore(vehicle.getType())).thenReturn(countReturn);
//		
//		Vigilant vigilante = new Vigilant(vehicleRepository, invoiceRepository, rateRepository, userRepository);
//		
//		// act
//		vigilante.isSpaceAviableCar(vehicle, spaceAvialbleCar);
//		
//		// Assert
//		assertTrue(vigilante.isSpaceAviableCar(vehicle, spaceAvialbleCar));
//	}
//	
//	@Test
//	public void isNotSpaceAviableCarTest() {
//		
//		// Arrange
//		
//		int spaceAvialbleCar = 20;
//		Long countReturn = 30L;
//		
//		VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder();
//		
//		Vehicle vehicle = vehicleTestDataBuilder.conType("CARRO").build();
//		
//		VehicleRepository vehicleRepository = mock(VehicleRepository.class);
//		InvoiceRepository invoiceRepository = mock(InvoiceRepository.class);
//		RateRepository rateRepository = mock(RateRepository.class);
//		UserRepository userRepository = mock(UserRepository.class);
//		
//		when(invoiceRepository.getByVehicleAndInvoiceStore(vehicle.getType())).thenReturn(countReturn);
//		
//		Vigilant vigilante = new Vigilant(vehicleRepository, invoiceRepository, rateRepository, userRepository);
//		
//		// act
//		vigilante.isSpaceAviableCar(vehicle, spaceAvialbleCar);
//		
//		// Assert
//		assertFalse(vigilante.isSpaceAviableCar(vehicle, spaceAvialbleCar));
//	}
//	
//	@Test
//	public void isSpaceAviableMotorBykeTest() {
//		
//		// Arrange
//		
//		int spaceAvialbleMotorByke = 10;
//		Long countReturn = 5L;
//		
//		VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder();
//		
//		Vehicle vehicle = vehicleTestDataBuilder.conType("MOTO").build();
//		
//		VehicleRepository vehicleRepository = mock(VehicleRepository.class);
//		InvoiceRepository invoiceRepository = mock(InvoiceRepository.class);
//		RateRepository rateRepository = mock(RateRepository.class);
//		UserRepository userRepository = mock(UserRepository.class);
//		
//		when(invoiceRepository.getByVehicleAndInvoiceStore(vehicle.getType())).thenReturn(countReturn);
//		
//		Vigilant vigilante = new Vigilant(vehicleRepository, invoiceRepository, rateRepository, userRepository);
//		
//		// act
//		vigilante.isSpaceAviableMotorByke(vehicle, spaceAvialbleMotorByke);
//		
//		// Assert
//		assertTrue(vigilante.isSpaceAviableMotorByke(vehicle, spaceAvialbleMotorByke));
//	}
//	
//	@Test
//	public void isNotSpaceAviableMotorBykeTest() {
//		
//		// Arrange
//		
//		int spaceAvialbleCar = 20;
//		Long countReturn = 30L;
//		
//		VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder();
//		
//		Vehicle vehicle = vehicleTestDataBuilder.conType("MOTO").build();
//		
//		VehicleRepository vehicleRepository = mock(VehicleRepository.class);
//		InvoiceRepository invoiceRepository = mock(InvoiceRepository.class);
//		RateRepository rateRepository = mock(RateRepository.class);
//		UserRepository userRepository = mock(UserRepository.class);
//		
//		when(invoiceRepository.getByVehicleAndInvoiceStore(vehicle.getType())).thenReturn(countReturn);
//		
//		Vigilant vigilante = new Vigilant(vehicleRepository, invoiceRepository, rateRepository, userRepository);
//		
//		// act
//		vigilante.isSpaceAviableMotorByke(vehicle, spaceAvialbleCar);
//		
//		// Assert
//		assertFalse(vigilante.isSpaceAviableMotorByke(vehicle, spaceAvialbleCar));
//	}

}


