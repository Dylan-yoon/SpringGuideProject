package com.baem.webservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsumingAResTfulWebServiceApplication {
	
	private static final Logger log = LoggerFactory.getLogger(ConsumingAResTfulWebServiceApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ConsumingAResTfulWebServiceApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Bean
	@Profile("!test")
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return arge -> {
			Quote quote = restTemplate.getForObject("http://localhost:8080/api/random", Quote.class);
			System.out.println(quote.toString());
			log.info(quote.toString());
		};
	}
}