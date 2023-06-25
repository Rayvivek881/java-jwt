package com.rayvivek881.jwtpractice.service;

import org.springframework.stereotype.Service;
import com.rayvivek881.jwtpractice.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
  private final List<User> store = new ArrayList<>(); // i have made it final

  public UserService() {
    for (int i = 0; i < 1e1; i += 1) {
      store.add(new User(
          UUID.randomUUID().toString(),
          "rayvivek" + i + "@gmail.com",
          "vivek " + i
      ));
    }
  }
  public List<User> getUser() {
    return this.store;
  }
}
