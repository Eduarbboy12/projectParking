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
			invoice = new Invoice(invoiceEntity.getVehicleEntity(), invoiceEntity.getRateEntity(), invoiceEntity.getDateinput(), invoiceEntity.getDateoutput(), invoiceEntity.getTimeparking(), invoiceEntity.getValuepay());
		}
		return invoice;
	}
	
	public static InvoiceEntity convertirAEntity(Invoice invoice) {
		InvoiceEntity invoiceEntity = new InvoiceEntity();
		invoiceEntity.setVehicleEntity(invoice.getVehicleEntity());
		invoiceEntity.setRateEntity(invoice.getRateEntity());
		invoiceEntity.setDateinput(invoice.getDateinput());
		invoiceEntity.setDateoutput(invoice.getDateoutput());
		invoiceEntity.setTimeparking(invoice.getTimeparking());
		invoiceEntity.setValuepay(invoice.getValuepay());
		return invoiceEntity;
	}

}
