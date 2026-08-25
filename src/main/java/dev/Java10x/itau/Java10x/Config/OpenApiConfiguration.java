package dev.Java10x.itau.Java10x.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .info(
                new Info()
                        .title("ITAU - curso JAVA10X")
                        .description("Api desafio tecnico ITAU + JAVA10X")
                        .version("1.0.0")
                );
    }
}
