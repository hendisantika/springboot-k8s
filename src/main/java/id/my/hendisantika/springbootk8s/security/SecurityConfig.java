package id.my.hendisantika.springbootk8s.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-k8s
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 17/01/26
 * Time: 13.00
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/login/**").permitAll()
                        .anyRequest().authenticated()

                )
                /*.exceptionHandling(e -> e
                        .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
               // .oauth2ResourceServer((oauth2) -> oauth2.jwt(withDefaults()));
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()));*/
                // Configure OAuth2 login
                .oauth2Login(oauth2Login ->
                        oauth2Login

                                .defaultSuccessUrl("/api/dashboard", true)
                                .failureUrl("/login?error=true")
                );

        return http.build();
    }
}
