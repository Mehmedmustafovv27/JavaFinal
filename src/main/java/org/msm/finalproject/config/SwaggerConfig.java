package org.msm.finalproject.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Veterinary Clinic REST API")
                        .version("1.0.0")
                        .description("REST API for managing veterinary clinic system")
                        .contact(apiContact())
                        .license(apiLicense()));
    }

    private Contact apiContact() {
        return new Contact()
                .name("Mehmed Mustafov")
                .email("student@example.com");
    }

    private License apiLicense() {
        return new License()
                .name("Apache License 2.0")
                .url("https://www.apache.org/licenses/LICENSE-2.0");
    }
}
