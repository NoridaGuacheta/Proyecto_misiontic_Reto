package com.misiontic.usergioarboleda.Ortesis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
@EntityScan("com.misiontic.usergioarboleda.Ortesis")

public class OrtesisApplication {
	public static void main(String[] args) {
		SpringApplication.run(OrtesisApplication.class, args);
	}

}
