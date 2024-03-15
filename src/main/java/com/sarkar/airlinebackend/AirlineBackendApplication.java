package com.sarkar.airlinebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
//import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@SpringBootApplication
//@EnableSwagger2WebMvc
//@SpringBootApplication(exclude = {HibernateJpaAutoConfiguration.class})
@EnableSwagger2
public class AirlineBackendApplication {

	public static void main(String[] args) {

		SpringApplication.run(AirlineBackendApplication.class, args);
	}

}
