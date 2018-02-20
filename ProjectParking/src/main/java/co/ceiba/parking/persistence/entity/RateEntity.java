package co.ceiba.parking.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity(name = "Rate")
@NamedQuery(name = "Rate.findById", query = "SELECT r FROM Rate r WHERE r.id = :id")
public class RateEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name = "type", nullable = false)
	private String type;
	
	@Column(name = "RateName", nullable = false)
	private String RateName;
	
	@Column(name = "RateValue", nullable = false)
	private int RateValue;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRateName() {
		return RateName;
	}

	public void setRateName(String rateName) {
		RateName = rateName;
	}

	public int getRateValue() {
		return RateValue;
	}

	public void setRateValue(int rateValue) {
		RateValue = rateValue;
	}

}
