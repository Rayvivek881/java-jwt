package com.rayvivek881.jwtpractice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppConfig {

//  @Bean
//  public UserDetailsService userDetailsService() {
//    UserDetails use1 =  User.builder().username("user1")
//        .password(passwordEncoder().encode("user1")).roles("ADMIN").build();
//    UserDetails use2 = User.builder().username("user2")
//        .password(passwordEncoder().encode("user2")).roles("ADMIN").build();
//    UserDetails use3 = User.builder().username("user3")
//        .password(passwordEncoder().encode("user3")).roles("NORMAL").build();
//    return new InMemoryUserDetailsManager(use1, use2, use3);
//  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
    return builder.getAuthenticationManager();
  }
}
