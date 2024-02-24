package com.one.digitalinnoovation.gof;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class OneDigitalInnoovationApplication {

	public static void main(String[] args) {
		SpringApplication.run(OneDigitalInnoovationApplication.class, args);
	}

}
