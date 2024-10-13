package com.usuario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@EnableAutoConfiguration
//@ComponentScan(basePackages = {"com.usuario"})
@SpringBootApplication
public class UserApiRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApiRestApplication.class, args);
	}

}
