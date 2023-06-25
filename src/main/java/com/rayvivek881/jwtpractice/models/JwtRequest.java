package com.rayvivek881.jwtpractice.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class JwtRequest {
  private String email;
  private String password;
}
