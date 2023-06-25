package com.rayvivek881.jwtpractice.config;

import com.rayvivek881.jwtpractice.security.JWTAuthenticationFilter;
import com.rayvivek881.jwtpractice.security.JwtAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {
  @Autowired
  private JwtAuthenticationEntryPoint point;

  @Autowired
  private JWTAuthenticationFilter filter;

  @Autowired
  private UserDetailsService userDetailsService;

  @Autowired
  private PasswordEncoder passwordEncoder;
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.csrf(AbstractHttpConfigurer::disable).cors(AbstractHttpConfigurer::disable)
        .authorizeRequests(auth -> auth.requestMatchers("/home/**").authenticated()
            .requestMatchers("/auth/**").permitAll().anyRequest().authenticated())
        .exceptionHandling(ex -> ex.authenticationEntryPoint(point))
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
    http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
    return http.build();
  }
  @Bean
  public DaoAuthenticationProvider doDaoAuthenticationProvider() {
    DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
    daoAuthenticationProvider.setUserDetailsService(userDetailsService);
    daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
    return daoAuthenticationProvider;
  }
}
