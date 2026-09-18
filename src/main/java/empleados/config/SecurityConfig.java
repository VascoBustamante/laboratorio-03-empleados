package empleados.config;

import empleados.model.UsuarioLogin;
import empleados.repository.UsuarioLoginRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(
            UsuarioLoginRepository repository) {

        return username -> {

            UsuarioLogin usuario = repository
                    .findByUsuario(username)
                    .orElseThrow();

            return User.builder()
                    .username(usuario.getUsuario())
                    .password(usuario.getPassword())
                    .roles("ADMIN")
                    .build();
        };
    }

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http) throws Exception {

        http
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/login").permitAll()
                    .anyRequest().authenticated()
            )

            .formLogin(form -> form
                    .loginPage("/login")
                    .defaultSuccessUrl("/empleados", true)
                    .failureUrl("/login?error=true")
                    .permitAll()
            )

            .logout(logout -> logout
                    .logoutSuccessUrl("/login?logout=true")
                    .permitAll()
            );

        return http.build();
    }

    @Bean
    public CommandLineRunner crearUsuarioInicial(
            UsuarioLoginRepository repository,
            PasswordEncoder passwordEncoder) {

        return args -> {

            if (repository.findByUsuario("admin").isEmpty()) {

                UsuarioLogin admin = new UsuarioLogin();

                admin.setUsuario("admin");
                admin.setPassword(
                        passwordEncoder.encode("admin123")
                );

                repository.save(admin);
            }
        };
    }
}