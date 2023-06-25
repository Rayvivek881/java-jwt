package com.rayvivek881.jwtpractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JwtPracticeApplication {

  public static void main(String[] args) {
    SpringApplication.run(JwtPracticeApplication.class, args);
    System.out.println("Server is running on port 8080");
  }
}
