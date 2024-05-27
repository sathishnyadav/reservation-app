package org.jsp.reservationapi;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReservationApiApplication {

	@Qualifier
	public static void main(String[] args) {
		SpringApplication.run(ReservationApiApplication.class, args);
	}

}
