package com.rest.api.tutorial.domains;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberResponse {
  private int id;
  private String firstName;
  private String lastName;
}
