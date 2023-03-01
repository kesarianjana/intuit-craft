package com.intuitinterview.craft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaRepositories
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.intuitinterview.craft.demo")
@EnableSwagger2
public class CraftApplication {

	public static void main(String[] args) {
		SpringApplication.run(CraftApplication.class, args);
	}

}
