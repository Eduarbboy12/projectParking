package co.ceiba.parking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackageClasses=co.ceiba.parking.persistence.entity.UserEntity.class)
@SpringBootApplication
public class ProjectParkingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectParkingApplication.class, args);
	}
}
