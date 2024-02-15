package dev.learning;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration {

    public WebMvcConfigurer corsConfigurer() {

        return new WebMvcConfigurer() {

            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // "/**" means allow to all incoming requests:
                // Spring Boot cors document:
                // https://spring.io/guides/gs/rest-service-cors#global-cors-configuration
                registry.addMapping("/**");
            }
        };
    }
}
