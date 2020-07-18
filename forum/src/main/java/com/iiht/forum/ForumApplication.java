package com.iiht.forum;

import org.modelmapper.ModelMapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages ="com.iiht.forum")
//@EnableJpaRepositories(basePackages ="com.iiht.forum.repository")
@EnableMongoRepositories(basePackages ="com.iiht.forum.repository")
@EntityScan("com.iiht.forum.model")
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class ForumApplication
{
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ForumApplication.class, args);
	}
}