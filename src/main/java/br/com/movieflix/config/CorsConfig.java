package br.com.movieflix.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Configuration
public class CorsConfig {

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        
        // Permite requisições de qualquer origem (ajuste conforme necessário)
        configuration.setAllowedOrigins(List.of("*"));
        
        // Ou se precisar enviar credenciais, use allowedOriginPatterns ao invés de allowedOrigins
        // configuration.setAllowedOriginPatterns(List.of("*"));
        // configuration.setAllowCredentials(true);
        
        // Permite todos os métodos HTTP
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH"));
        
        // Permite todos os headers
        configuration.setAllowedHeaders(List.of("*"));
        
        // Expõe headers na resposta
        configuration.setExposedHeaders(Arrays.asList("Authorization", "Content-Type"));
        
        // Tempo de cache do preflight (em segundos)
        configuration.setMaxAge(3600L);
        
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        
        return source;
    }
}
