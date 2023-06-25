package com.rayvivek881.jwtpractice.models;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
  private String userId;
  private String email;
  private String name;
}
