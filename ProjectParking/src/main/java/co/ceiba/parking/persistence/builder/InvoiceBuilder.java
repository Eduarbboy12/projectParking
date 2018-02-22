package co.ceiba.parking.persistence.builder;

import co.ceiba.parking.dominio.Invoice;
import co.ceiba.parking.dominio.Rate;
import co.ceiba.parking.dominio.Vehicle;
import co.ceiba.parking.persistence.entity.InvoiceEntity;
import co.ceiba.parking.persistence.entity.RateEntity;
import co.ceiba.parking.persistence.entity.VehicleEntity;

public class InvoiceBuilder {

	public InvoiceBuilder() {
	}

	public static Invoice convertirADominio(InvoiceEntity invoiceEntity) {
		Invoice invoice = null;
		if (invoiceEntity != null) {

			Vehicle vehiculo = new Vehicle(invoiceEntity.getVehicle().getType(),
					invoiceEntity.getVehicle().getPlaque(), invoiceEntity.getVehicle().getCylinder(),
					invoiceEntity.getVehicle().getDocument());
			
			Rate rate = new Rate(invoiceEntity.getRateEntity().getType(), invoiceEntity.getRateEntity().getRateName(),
					invoiceEntity.getRateEntity().getRateValue());

			invoice = new Invoice(vehiculo, rate, invoiceEntity.getDateinput(),
					invoiceEntity.getDateoutput(), invoiceEntity.getTimeparking(), invoiceEntity.getValuepay());
		}
		return invoice;
	}

	public static InvoiceEntity convertirAEntity(Invoice invoice) {
		
		VehicleEntity vehicleEntity = new VehicleEntity();
		vehicleEntity.setType(invoice.getVehicle().getType());
		vehicleEntity.setPlaque(invoice.getVehicle().getPlaque());
		vehicleEntity.setDocument(invoice.getVehicle().getDocument());
		vehicleEntity.setCylinder(invoice.getVehicle().getCylinder());
		
		RateEntity rateEntity = new RateEntity();
		rateEntity.setType(invoice.getRate().getType());
		rateEntity.setRateName(invoice.getRate().getRatename());
		rateEntity.setRateValue(invoice.getRate().getRatevalue());
		
		InvoiceEntity invoiceEntity = new InvoiceEntity();
		invoiceEntity.setVehicle(vehicleEntity);
		invoiceEntity.setRateEntity(rateEntity);
		invoiceEntity.setDateinput(invoice.getDateinput());
		invoiceEntity.setDateoutput(invoice.getDateoutput());
		invoiceEntity.setTimeparking(invoice.getTimeparking());
		invoiceEntity.setValuepay(invoice.getValuepay());
		return invoiceEntity;
	}

}
