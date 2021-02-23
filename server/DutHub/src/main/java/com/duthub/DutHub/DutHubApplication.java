package com.duthub.DutHub;

import com.duthub.DutHub.bll.helpers.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class DutHubApplication {

	public static void main(String[] args) {
		SpringApplication.run(DutHubApplication.class, args);
	}

}
