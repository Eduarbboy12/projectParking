package co.ceiba.parking.persistence.builder;

import co.ceiba.parking.dominio.Rate;
import co.ceiba.parking.persistence.entity.RateEntity;

public class RateBuilder {
	
	/**
	 * Constructor
	 */
	public RateBuilder() {
	}

	public static Rate convertirADominio(RateEntity rateEntity) {
		Rate rate = null;
		if (rateEntity != null) {
			rate = new Rate(rateEntity.getType(), rateEntity.getRateName(), rateEntity.getRateValue());
		}
		return rate;
	}

	public static RateEntity convertirAEntity(Rate rate) {
		RateEntity rateEntity = new RateEntity();
		rateEntity.setType(rate.getType());
		rateEntity.setRateName(rate.getRatename());
		rateEntity.setRateValue(rate.getRatevalue());
		return rateEntity;
	}

}
