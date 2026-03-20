package com.mauricioffdev.sistema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
@EnableWebSecurity
public class SistemaAulasApplication {

    public static void main(String[] args) {
        SpringApplication.run(SistemaAulasApplication.class, args);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        // 1. Block
                        .requestMatchers("/alunos/novo", "/alunos/salvar", "/alunos/editar/**", "/alunos/excluir/**").authenticated()
                        .requestMatchers("/financeiro", "/financeiro/**").authenticated()

                        // 2. A VITRINE (Público)
                        .anyRequest().permitAll()
                )
                // 3. O MATA-MEMÓRIA
                .formLogin(form -> form
                        .defaultSuccessUrl("/alunos", true) // O "true" obriga a ir para a lista, apagando qualquer clique anterior
                        .permitAll()
                )
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}