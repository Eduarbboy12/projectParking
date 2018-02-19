package co.ceiba.parking.builder;

import co.ceiba.parking.Entity.InvoiceEntity;
import co.ceiba.parking.dominio.Invoice;

public class InvoiceBuilder {
	
	public InvoiceBuilder() {
	}
	
	public static Invoice convertirADominio(InvoiceEntity invoiceEntity) {
		Invoice invoice = null;
		if(invoiceEntity != null) {
			invoice = new Invoice(invoiceEntity.getVehicle(), invoiceEntity.getIngreso(), invoiceEntity.getSalida(), invoiceEntity.getValortotal());
		}
		return invoice;
	}

}
