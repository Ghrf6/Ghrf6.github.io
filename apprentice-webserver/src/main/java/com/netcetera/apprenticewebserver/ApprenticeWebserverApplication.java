package com.netcetera.apprenticewebserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// TODO: Describe what this annotation does. What happens here?
// The specific ApprenticeWebserverApplicationConfiguration.java class has been removed but it still works as before.
@ComponentScan(basePackages = "com.netcetera")
public class ApprenticeWebserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApprenticeWebserverApplication.class, args);
	}

}
