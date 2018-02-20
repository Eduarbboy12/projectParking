package co.ceiba.parking.testdatabuilder;

import co.ceiba.parking.dominio.Rate;

public class RateTestDataBuilder {
	
	private static final String TYPE = "CARRO";
	private static final String RATENAME = "TARIFA 1";
	private static final int RATEVALUE = 5000;
	
	private String type;
	private String rateName;
	private int rateValue;
	
	public RateTestDataBuilder() {
		this.type = TYPE;
		this.rateName = RATENAME;
		this.rateValue = RATEVALUE;
	}
	
	public RateTestDataBuilder conType(String type) {
		this.type = type;
		return this;
	}
	
	public RateTestDataBuilder conRateName(String rateName) {
		this.rateName = rateName;
		return this;
	}
	
	public RateTestDataBuilder conRateValue(int rateValue) {
		this.rateValue = rateValue;
		return this;
	}
	
	public Rate build() {
		return new Rate(this.type, this.rateName, this.rateValue);
	}

}
