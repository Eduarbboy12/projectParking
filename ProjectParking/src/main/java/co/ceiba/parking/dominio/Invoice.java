package co.ceiba.parking.dominio;

import java.util.Date;

import co.ceiba.parking.persistence.entity.RateEntity;
import co.ceiba.parking.persistence.entity.VehicleEntity;

public class Invoice {

	private VehicleEntity vehicleEntity;
	private RateEntity rateEntity;
	private Date dateinput;
	private Date dateoutput;
	private double valuepay;
	private double timeparking;
	
	public Invoice(VehicleEntity vehicleEntity, RateEntity rateEntity, Date dateinput, Date dateoutput, double valuepay, double timeparking) {
		this.vehicleEntity = vehicleEntity;
		this.rateEntity = rateEntity;
		this.dateinput = dateinput;
		this.dateoutput = dateoutput;
		this.valuepay = valuepay;
		this.timeparking = timeparking;
	}

	public VehicleEntity getVehicleEntity() {
		return vehicleEntity;
	}

	public void setVehicleEntity(VehicleEntity vehicleEntity) {
		this.vehicleEntity = vehicleEntity;
	}

	public RateEntity getRateEntity() {
		return rateEntity;
	}

	public void setRateEntity(RateEntity rateEntity) {
		this.rateEntity = rateEntity;
	}

	public Date getDateinput() {
		return dateinput;
	}

	public void setDateinput(Date dateinput) {
		this.dateinput = dateinput;
	}

	public Date getDateoutput() {
		return dateoutput;
	}

	public void setDateoutput(Date dateoutput) {
		this.dateoutput = dateoutput;
	}

	public double getValuepay() {
		return valuepay;
	}

	public void setValuepay(double valuepay) {
		this.valuepay = valuepay;
	}

	public double getTimeparking() {
		return timeparking;
	}

	public void setTimeparking(double timeparking) {
		this.timeparking = timeparking;
	}
	
}
