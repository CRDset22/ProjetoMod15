package br.com.ebac.memelandia.servidormeme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServidorMemeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServidorMemeApplication.class, args);
	}

}
