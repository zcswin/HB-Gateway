package charles.zhou.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {
 
    @Bean
    SecurityWebFilterChain securityFilterChain(ServerHttpSecurity http) {
        return http
            .authorizeExchange(exchanges -> exchanges
                    .pathMatchers(
                    		"/",
                            "/swagger-ui.html",
                            "/swagger-ui/**",
                            "/v3/api-docs/**",
                            "/webjars/**",
                            "/swagger-resources/**",
                            "/favicon.ico",
                            "/actuator/**"
                        ).permitAll()
                        .anyExchange().permitAll()
            )            
            .csrf(ServerHttpSecurity.CsrfSpec::disable)
            .formLogin(ServerHttpSecurity.FormLoginSpec::disable)
            .httpBasic(ServerHttpSecurity.HttpBasicSpec::disable)
            .build();
    }
    
    @Bean
    CorsWebFilter corsFilter() {
        return new CorsWebFilter(exchange -> new CorsConfiguration()
                .applyPermitDefaultValues());
    }
}