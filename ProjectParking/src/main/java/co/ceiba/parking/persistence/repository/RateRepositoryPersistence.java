package co.ceiba.parking.persistence.repository;

import co.ceiba.parking.dominio.Rate;
import co.ceiba.parking.dominio.repositorio.RateRepository;
import co.ceiba.parking.persistence.builder.RateBuilder;
import co.ceiba.parking.persistence.entity.RateEntity;
import co.ceiba.parking.persistence.repository.jpa.RateRepositoryJPA;

public class RateRepositoryPersistence implements RateRepository {
	
	private RateRepositoryJPA rateRepositoryJPA;
	
	public Rate getByRateName(String rateName) {
		RateEntity rateEntity =  rateRepositoryJPA.findByRateName(rateName);
		return RateBuilder.convertirADominio(rateEntity);
	}

}
