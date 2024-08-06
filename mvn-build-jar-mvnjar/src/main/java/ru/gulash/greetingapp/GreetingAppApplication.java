package ru.gulash.greetingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ConfigurableApplicationContext;

@ConfigurationPropertiesScan
@SpringBootApplication
public class GreetingAppApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(GreetingAppApplication.class, args);
	}
}
