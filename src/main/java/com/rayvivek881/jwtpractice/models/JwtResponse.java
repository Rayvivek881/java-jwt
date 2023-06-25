package com.rayvivek881.jwtpractice.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class JwtResponse {
  private String jwtToken;
  private String username;
}
