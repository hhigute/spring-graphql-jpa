package com.h3b.investment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringGraphqlJpaApplication {

	public static void main(String[] args) {
		
		//SchemaParser.newParser().file("customer.graphqls");
		SpringApplication.run(SpringGraphqlJpaApplication.class, args);
	}
	
	
}
