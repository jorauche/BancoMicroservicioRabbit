package beto.banco.notificacion.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class ApplicationConfig {
	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}
	
	
}
