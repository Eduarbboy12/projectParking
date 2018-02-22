package co.ceiba.parking.persistence.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity(name = "Invoice")
@NamedQuery(name = "Invoice.findById", query = "SELECT i FROM Invoice i WHERE i.id = :id")
public class InvoiceEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	@JoinColumn(name="vehicle",referencedColumnName="id")
	private VehicleEntity vehicle;
	
	@ManyToOne
	@JoinColumn(name="rate",referencedColumnName="id")
	private RateEntity rate;
	
	@Column(name = "dateinput")
	private Date dateinput;
	
	@Column(name = "dateoutput")
	private Date dateoutput;

	@Column(name = "timeparking")
	private double timeparking;
	
	@Column(name = "valuepay")
	private double valuepay;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public VehicleEntity getVehicle() {
		return vehicle;
	}

	public void setVehicle(VehicleEntity vehicle) {
		this.vehicle = vehicle;
	}

	public RateEntity getRateEntity() {
		return rate;
	}

	public void setRateEntity(RateEntity rateEntity) {
		this.rate = rateEntity;
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

	public double getTimeparking() {
		return timeparking;
	}

	public void setTimeparking(double timeparking) {
		this.timeparking = timeparking;
	}

	public double getValuepay() {
		return valuepay;
	}

	public void setValuepay(double valuepay) {
		this.valuepay = valuepay;
	}
	
}
