package hu.unideb.inf.autokereskedes;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class AutokereskedesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutokereskedesApplication.class, args);
	}

	@Bean
	ModelMapper modelMapper() {
		//return new ModelMapper();
		ModelMapper m = new ModelMapper();
		return m;
	}

}
