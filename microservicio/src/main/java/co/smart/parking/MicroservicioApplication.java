package co.smart.parking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "co.smart.parking")
public class MicroservicioApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioApplication.class, args);
	}

}
