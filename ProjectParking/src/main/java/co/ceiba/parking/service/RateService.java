package co.ceiba.parking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.ceiba.parking.persistence.entity.RateEntity;
import co.ceiba.parking.persistence.repository.jpa.RateRepositoryJPA;

@Service
public class RateService {
	
	@Autowired
	private RateRepositoryJPA rateRepositoryJPA;
	
	public Object findAll() {
		return rateRepositoryJPA.findAll();
	}
	
	public RateEntity findById(long id) {
		return rateRepositoryJPA.findOne(id);
	}
	
	public RateEntity save(RateEntity rateEntity){
        return rateRepositoryJPA.save(rateEntity);
    }
	
	public void delete(RateEntity rateEntity) {
		rateRepositoryJPA.delete(rateEntity);
		return;
	}

}
