package co.ceiba.parking.persistence.repository;

import javax.persistence.EntityManager;

import co.ceiba.parking.dominio.Rate;
import co.ceiba.parking.dominio.repositorio.RateRepository;
import co.ceiba.parking.persistence.builder.RateBuilder;
import co.ceiba.parking.persistence.entity.RateEntity;
import co.ceiba.parking.persistence.repository.jpa.RateRepositoryJPA;

public class RateRepositoryPersistence implements RateRepository {
	
	private EntityManager entityManager;
	private RateRepositoryJPA rateRepositoryJPA;
	
	public RateRepositoryPersistence(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public Rate getByRateName(String rateName) {
		RateEntity rateEntity =  rateRepositoryJPA.findByRateName(rateName);
		return RateBuilder.convertirADominio(rateEntity);
	}

}
