package hu.unideb.inf.autokereskedes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Az összes végpont engedélyezése
                        .allowedOrigins("http://localhost:4200") // Angular alkalmazás eredete
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Engedélyezett metódusok
                        .allowedHeaders("*") // Összes fejléc engedélyezése
                        .allowCredentials(true); // Ha szükséges a sütik küldése
            }
        };
    }
}
