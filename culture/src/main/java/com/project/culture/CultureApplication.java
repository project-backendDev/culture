package com.project.culture;

//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableBatchProcessing
public class CultureApplication {

	public static void main(String[] args) {
		SpringApplication.run(CultureApplication.class, args);
	}

}
