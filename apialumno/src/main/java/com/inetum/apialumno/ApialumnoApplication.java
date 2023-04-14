package com.inetum.apialumno;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients("com.inetum.apialumno.proxy")
@ComponentScan(basePackages = "com.inetum.apialumno")
public class ApialumnoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApialumnoApplication.class, args);
	}
}
