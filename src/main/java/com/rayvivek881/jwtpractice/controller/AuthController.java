package com.rayvivek881.jwtpractice.controller;

import com.rayvivek881.jwtpractice.entities.User;
import com.rayvivek881.jwtpractice.security.JwtHelper;
import com.rayvivek881.jwtpractice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import com.rayvivek881.jwtpractice.models.JwtRequest;
import com.rayvivek881.jwtpractice.models.JwtResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {
  @Autowired
  private UserDetailsService userDetailsService;
  @Autowired
  private AuthenticationManager manager;
  @Autowired
  private JwtHelper jwtHelper;

  @Autowired
  private UserService userService;

  private final Logger logger = LoggerFactory.getLogger(AuthController.class);
  @PostMapping("/login")
  public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {
    this.doAuthenticate(request.getEmail(), request.getPassword());
    UserDetails userDetails = this.userDetailsService.loadUserByUsername(request.getEmail());
    String token = jwtHelper.generateToken(userDetails);
    JwtResponse response = JwtResponse.builder().jwtToken(token)
        .username(userDetails.getUsername()).build();
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
  private void doAuthenticate(String email, String password) {
    UsernamePasswordAuthenticationToken authenticationToken =  new UsernamePasswordAuthenticationToken(email, password);
    try {
      manager.authenticate(authenticationToken);
    } catch (BadCredentialsException e) {
      throw new BadCredentialsException(" Invalid Username or Password !!");
    }
  }
  @ExceptionHandler(BadCredentialsException.class)
  public String exceptionHandler() {
    return  "Credentials Invalid !!";
  }

  @PostMapping("/signup")
  public User createUser(@RequestBody User user) {
    return userService.createUser(user);
  }
}
