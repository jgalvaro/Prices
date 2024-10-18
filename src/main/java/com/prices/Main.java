package com.prices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.prices.domain")
@EnableJpaRepositories(basePackages = "com.prices.infrastructure")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
