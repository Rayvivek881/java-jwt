package com.rayvivek881.jwtpractice.controller;

import com.rayvivek881.jwtpractice.models.User;
import com.rayvivek881.jwtpractice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/home")
public class homeController {

  @Autowired
  private UserService userService;

  @GetMapping("/user")
  @ResponseStatus(HttpStatus.OK)
  public List<User> getUser() {
    return userService.getUser();
  }

  @GetMapping("/current-user")
  public String getLoggedInUser(Principal principal) {
    System.out.println(principal);
    return principal.getName();
  }
}
