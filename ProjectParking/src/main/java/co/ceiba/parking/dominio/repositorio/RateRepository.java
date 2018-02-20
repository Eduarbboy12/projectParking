package co.ceiba.parking.dominio.repositorio;

import co.ceiba.parking.dominio.Rate;

public interface RateRepository {
	
	Rate getByRateName(String rateName);

}
