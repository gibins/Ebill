package com.ebill.api;


/*
 * JpaRepository
 * https://programmer.help/blogs/talk-about-simple-jpa-repository-of-spring-data-jpa.html
 * 
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
//@ComponentScan
//@EnableJpaRepositories("com.ebill.api.repository.impl")
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

}
