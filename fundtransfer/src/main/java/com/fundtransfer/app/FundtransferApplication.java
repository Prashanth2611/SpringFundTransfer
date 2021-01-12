package com.fundtransfer.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.fundtransfer.controller", "com.fundtransfer.dao", "com.fundtransfer.model",
		"com.fundtransfer.service", "com.fundtransfer.security", "com.fundtransfer.dto" })
@EnableJpaRepositories("com.fundtransfer.repo")
@EnableTransactionManagement
@EntityScan("com.fundtransfer.model")
public class FundtransferApplication {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(FundtransferApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(FundtransferApplication.class, args);
	}

}
