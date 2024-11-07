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
		return args -> {
			Quote quote = restTemplate.getForObject("http://localhost:8080/api/random", Quote.class);
			log.info(quote.toString());
			System.out.println(quote.toString());
		};
	}
}

//package com.baem.webservice;
//
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.web.client.RestTemplateBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Profile;
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.http.HttpMethod;
//import org.springframework.web.client.RestTemplate;
//
//@SpringBootApplication
//public class ConsumingAResTfulWebServiceApplication {
//	
//	private static final Logger log = LoggerFactory.getLogger(ConsumingAResTfulWebServiceApplication.class);
//	
//	public static void main(String[] args) {
//		SpringApplication.run(ConsumingAResTfulWebServiceApplication.class, args);
//	}
//
//	@Bean
//	public RestTemplate restTemplate(RestTemplateBuilder builder) {
//		return builder.build();
//	}
//	
//	@Bean
//	@Profile("!test")
//	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
//		return arge -> {
//			// Guide에서의 방식.
////			Quote quote = restTemplate.getForObject("http://localhost:8080/api/random", Quote.class);
////			System.out.println(quote.toString());
////			log.info(quote.toString());
//			String url = "https://api.unsplash.com/photos/random/?{key=value}&count=1";
//
//            List<Unsplash> unsplashPhotos = restTemplate.exchange(
//                url,
//                HttpMethod.GET,
//                null,
//                new ParameterizedTypeReference<List<Unsplash>>() {}
//            ).getBody();
//
//            if (unsplashPhotos != null && !unsplashPhotos.isEmpty()) {
//            	Unsplash unsplash = unsplashPhotos.get(0);
//                System.out.println(unsplash.toString());
//                // log.info .warn, .error 출력 해보기 
//                log.info(unsplash.toString());
//                log.warn(unsplash.toString());
//                log.error(unsplash.toString());
//            }
//		};
//	}
//}
//
