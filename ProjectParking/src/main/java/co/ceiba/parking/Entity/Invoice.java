package co.ceiba.parking.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity(name = "Invoice")
@NamedQuery(name = "Invoice.findById", query = "SELECT i FROM Invoice i WHERE i.id = :id")
public class Invoice {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name = "vehiculo")
	private String vehiculo;
	
	@Column(name = "ingreso")
	private String ingreso;
	
	@Column(name = "salida")
	private String salida;
	
	@Column(name = "valortotal")
	private String valortotal;

}
