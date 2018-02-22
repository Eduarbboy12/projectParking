package co.ceiba.parking.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity(name = "Vehicle")
@NamedQuery(name = "Vehicle.findByPlaque", query = "SELECT vehicle FROM Vehicle vehicle WHERE vehicle.plaque = :plaque")
public class VehicleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "type", nullable = false)
	private String type;

	@Column(name = "plaque", nullable = false)
	private String plaque;

	@Column(name = "cylinder")
	private String cylinder;

	@Column(name = "document")
	private String document;

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

	public String getPlaque() {
		return plaque;
	}

	public void setPlaque(String plaque) {
		this.plaque = plaque;
	}

	public String getCylinder() {
		return cylinder;
	}

	public void setCylinder(String cylinder) {
		this.cylinder = cylinder;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

}
