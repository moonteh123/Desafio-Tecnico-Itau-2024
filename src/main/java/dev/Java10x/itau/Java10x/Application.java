package dev.Java10x.itau.Java10x;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import dev.Java10x.itau.Java10x.Estatisticas.EstatisticasProp;

@SpringBootApplication
@EnableConfigurationProperties(EstatisticasProp.class)
@ConfigurationPropertiesScan
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
