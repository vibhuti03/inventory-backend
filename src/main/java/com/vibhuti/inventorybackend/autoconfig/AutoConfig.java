package com.vibhuti.inventorybackend.autoconfig;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.vibhuti.inventorybackend.*")
@ComponentScan(basePackages = {"com.vibhuti.inventorybackend.*"})
@EntityScan("com.vibhuti.inventorybackend.*")
@PropertySource("classpath:inventorybackend.properties")
public class AutoConfig {
}
