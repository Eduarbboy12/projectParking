package co.ceiba.parking.dominio;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import co.ceiba.parking.testdatabuilder.VehicleTestDataBuilder;

public class VehicleTest {
	
	private static final String TYPE = "CARRO";
	private static final String PLAQUE = "ABC123";
	private static final String CYLINDER = "200";
	private static final String DOCUMENT = "1102360555";
	
	@Test
	public void createVehicleTest() {
		
		// Arrange
		VehicleTestDataBuilder vehicleTestDataBuilder = new VehicleTestDataBuilder()
				.conType(TYPE)
				.conPlaque(PLAQUE)
				.conCylinder(CYLINDER)
				.conDocument(DOCUMENT);
		// Act
		Vehicle vehicle = vehicleTestDataBuilder.build();
		
		// Assert
		assertEquals(TYPE, vehicle.getType());
		assertEquals(PLAQUE, vehicle.getPlaque());
		assertEquals(CYLINDER, vehicle.getCylinder());
		assertEquals(DOCUMENT, vehicle.getDocument());
		
		
	}

}
