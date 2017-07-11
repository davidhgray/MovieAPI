package com.lmig.moviedb;

import com.lmig.moviedb.MovieRepository;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestBody;

@SpringBootApplication
@EnableSwagger2
public class MovieApp {

	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(MovieApp.class, args);
	}
	
	@Bean
	public Docket swaggerSettings() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build()
				.pathMapping("/");
	}

}
