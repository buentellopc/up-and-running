package com.bpc.upandrunning;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@SpringBootApplication
@ConfigurationPropertiesScan
public class UpAndRunningApplication implements CommandLineRunner {

	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext = SpringApplication.run(UpAndRunningApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}



























