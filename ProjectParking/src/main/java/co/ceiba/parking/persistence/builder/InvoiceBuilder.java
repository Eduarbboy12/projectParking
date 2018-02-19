package co.ceiba.parking.persistence.builder;

import co.ceiba.parking.dominio.Invoice;
import co.ceiba.parking.dominio.Vehicle;
import co.ceiba.parking.persistence.entity.InvoiceEntity;

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
	
	public static InvoiceEntity convertirAEntity(Invoice invoice) {
		InvoiceEntity invoiceEntity = new InvoiceEntity();
		invoiceEntity.setIngreso(invoice.getIngreso());
		invoiceEntity.setSalida(invoice.getSalida());
		invoiceEntity.setValortotal(invoice.getValortotal());
		invoiceEntity.setVehicle(invoice.getVehicle());
		return invoiceEntity;
	}

}
