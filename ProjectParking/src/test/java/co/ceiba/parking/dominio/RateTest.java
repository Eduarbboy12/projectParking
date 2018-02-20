package co.ceiba.parking.dominio;

import static org.junit.Assert.*;

import org.junit.Test;

import co.ceiba.parking.testdatabuilder.RateTestDataBuilder;

public class RateTest {
	
	private static final String TYPE = "CARRO";
	private static final String RATENAME = "TARIFA 1";
	private static final int RATEVALUE = 5000;

	@Test
	public void createRateTest() {
		// Arrange
		RateTestDataBuilder rateTestDataBuilder = new RateTestDataBuilder()
				.conType(TYPE)
				.conRateName(RATENAME)
				.conRateValue(RATEVALUE);
		
		// Act
		Rate rate = rateTestDataBuilder.build();
		
		//
		assertEquals(TYPE, rate.getType());
		assertEquals(RATENAME, rate.getRatename());
		assertEquals(RATEVALUE, rate.getRatevalue());
		
	}

}
