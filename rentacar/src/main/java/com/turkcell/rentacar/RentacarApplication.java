package com.turkcell.rentacar;

import com.turkcell.rentacar.adapters.abstracts.FindexHttpAdapter;
import com.turkcell.rentacar.adapters.abstracts.PosHttpAdapter;
import com.turkcell.rentacar.adapters.concretes.FindexRestTemplateAdapter;
import com.turkcell.rentacar.adapters.concretes.PosRestTemplateAdapter;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
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
	public FindexHttpAdapter findexHttpAdapter(RestTemplate restTemplate) {
		return new FindexRestTemplateAdapter(restTemplate);
	}

	@Bean
	public PosHttpAdapter posHttpAdapter(RestTemplate restTemplate) {
		return new PosRestTemplateAdapter(restTemplate);
	}

}
