package com.rayvivek881.jwtpractice.repositories;

import com.rayvivek881.jwtpractice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
  public Optional<User> findByEmail(String email);
}
