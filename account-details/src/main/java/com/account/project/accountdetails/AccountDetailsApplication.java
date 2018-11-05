package com.account.project.accountdetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.account.project.accoundetails.dao")
public class AccountDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountDetailsApplication.class, args);
	}
}
