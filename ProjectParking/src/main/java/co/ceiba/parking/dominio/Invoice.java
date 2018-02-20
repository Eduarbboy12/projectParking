package co.ceiba.parking.dominio;

import java.util.Date;

import co.ceiba.parking.persistence.entity.RateEntity;
import co.ceiba.parking.persistence.entity.VehicleEntity;

public class Invoice {

	private Vehicle vehicle;
	private Rate rate;
	private Date dateinput;
	private Date dateoutput;
	private double valuepay;
	private double timeparking;
	
	public Invoice(Vehicle vehicle, Rate rate, Date dateinput, Date dateoutput, double valuepay, double timeparking) {
		this.vehicle = vehicle;
		this.rate = rate;
		this.dateinput = dateinput;
		this.dateoutput = dateoutput;
		this.valuepay = valuepay;
		this.timeparking = timeparking;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Rate getRate() {
		return rate;
	}

	public void setRate(Rate rate) {
		this.rate = rate;
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
