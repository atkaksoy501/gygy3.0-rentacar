package com.turkcell.rentacar;

import com.turkcell.rentacar.adapters.HttpAdapter;
import com.turkcell.rentacar.adapters.RestTemplateAdapter;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RentacarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentacarApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public HttpAdapter httpAdapter(RestTemplate restTemplate) {
		return new RestTemplateAdapter(restTemplate);
	}

}
