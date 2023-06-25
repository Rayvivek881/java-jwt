package com.rayvivek881.jwtpractice.service;

import com.rayvivek881.jwtpractice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.rayvivek881.jwtpractice.entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
  private final List<User> store = new ArrayList<>(); // i have made it final

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public List<User> getUser() {
    return userRepository.findAll();
  }
  public User createUser(User user) {
    user.setUserId(UUID.randomUUID().toString());
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    return userRepository.save(user);
  };
}
