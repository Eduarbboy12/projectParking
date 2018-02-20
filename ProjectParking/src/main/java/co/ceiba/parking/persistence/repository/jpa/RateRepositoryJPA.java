package co.ceiba.parking.persistence.repository.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.ceiba.parking.persistence.entity.RateEntity;

@Repository
public interface RateRepositoryJPA extends CrudRepository<RateEntity, Long>{
	public RateEntity findByRateName(String rateName);

}
