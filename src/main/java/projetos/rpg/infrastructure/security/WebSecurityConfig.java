package projetos.rpg.infrastructure.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(Customizer.withDefaults()) // Habilita CORS com configurações padrão
                .csrf(csrf -> csrf.disable()) // ATENÇÃO: Desabilitado para desenvolvimento - habilitar em produção com token management
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/css/**", "/js/**", "/images/**", "/webjars/**").permitAll()
                        .requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll()
                        .requestMatchers("/login", "/login?error", "/login?logout").permitAll()
                        .requestMatchers(HttpMethod.POST, "/jogador/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/jogador/**").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/jogador/**").permitAll()
                        // Todas as outras requisições exigem autenticação
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/HomeJogador", true) // Redirecionamento pós-login
                        .failureUrl("/login?error=true") // Tratamento de falha
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout") // Feedback de logout
                        .invalidateHttpSession(true) // Invalida sessão
                        .deleteCookies("JSESSIONID") // Remove cookies
                        .permitAll()
                )
                .exceptionHandling(exception -> exception
                        .accessDeniedPage("/acesso-negado") // Página customizada para acesso negado
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}