package co.ceiba.parking.testdatabuilder;

import java.util.Calendar;
import java.util.Date;

import co.ceiba.parking.persistence.entity.RateEntity;
import co.ceiba.parking.persistence.entity.VehicleEntity;
import co.ceiba.parking.util.dateUtilityTest;

public class InvoiceTestDataBuilder {
	
	private static final Date DATEINPUT = dateUtilityTest.crearFechaConHora(01, Calendar.FEBRUARY, 2018, 10, 30);
	private static final Date DATEOUTPUT = dateUtilityTest.crearFechaConHora(10, Calendar.FEBRUARY, 2018, 10, 30);
	private static final double VALUEPAY = 10000;
	private static final double TIMEPARKING = 2;
	
	private VehicleEntity vehicleEntity;
	private RateEntity rateEntity;
	private Date dateinput;
	private Date dateoutput;
	private double valuepay;
	private double timeparking;

}
