package co.ceiba.parking.testdatabuilder;

import java.util.Calendar;
import java.util.Date;

import co.ceiba.parking.dominio.Invoice;
import co.ceiba.parking.dominio.Rate;
import co.ceiba.parking.dominio.Vehicle;
import co.ceiba.parking.persistence.builder.InvoiceBuilder;
import co.ceiba.parking.persistence.builder.VehicleBuilder;
import co.ceiba.parking.persistence.entity.RateEntity;
import co.ceiba.parking.persistence.entity.VehicleEntity;
import co.ceiba.parking.util.dateUtilityTest;

public class InvoiceTestDataBuilder {
	
	private static final Date DATEINPUT = dateUtilityTest.crearFechaConHora(01, Calendar.FEBRUARY, 2018, 10, 30);
	private static final Date DATEOUTPUT = dateUtilityTest.crearFechaConHora(10, Calendar.FEBRUARY, 2018, 10, 30);
	private static final double VALUEPAY = 10000;
	private static final double TIMEPARKING = 2;
	
	private Vehicle vehicle;
	private Rate rate;
	private Date dateinput;
	private Date dateoutput;
	private double valuepay;
	private double timeparking;
	
	public InvoiceTestDataBuilder() {
		this.vehicle = new VehicleTestDataBuilder().build();
		this.rate = new RateTestDataBuilder().build();
		this.dateinput = DATEINPUT;
		this.dateoutput = DATEOUTPUT;
		this.valuepay = VALUEPAY;
		this.timeparking = TIMEPARKING;
	}
	
	public InvoiceTestDataBuilder conVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
		return this;
	}
	
	public InvoiceTestDataBuilder conRate(Rate rate) {
		this.rate = rate;
		return this;
	}
	
	public InvoiceTestDataBuilder conDateInput(Date dateinput) {
		this.dateinput = dateinput;
		return this;
	}
	
	public InvoiceTestDataBuilder conDateOutput(Date dateoutput) {
		this.dateoutput = dateoutput;
		return this;
	}
	
	public InvoiceTestDataBuilder conValePay(double valuepay) {
		this.valuepay = valuepay;
		return this;
	}
	
	public InvoiceTestDataBuilder conTimeParking(double timeparking) {
		this.timeparking = timeparking;
		return this;
	}
	
	public Invoice build() {		
		return new Invoice(this.vehicle, this.rate, this.dateinput, this.dateoutput, this.valuepay, this.timeparking);
	}

}
