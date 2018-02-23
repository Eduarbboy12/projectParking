package co.ceiba.parking.dominio.repositorio;

public interface InvoiceRepository {
		
	/**
	 * 
	 * @param vehicle
	 * @return
	 */
	Long getByVehicleAndInvoiceStore(String type);

}
