package com.fvelasquez.prueba.infraestructure.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Permitir todas las rutas
                        .allowedOrigins("http://localhost:4200") // Permitir solicitudes desde el cliente Angular
                        .allowedMethods("GET", "POST", "PUT","PATCH", "DELETE", "OPTIONS"); // Métodos permitidos
            }
        };
    }
}