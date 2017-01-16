package org.glsid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
//@ImportResource("spring-beans.xml")
public class BanqueEnsaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BanqueEnsaApplication.class, args);
	}
}
