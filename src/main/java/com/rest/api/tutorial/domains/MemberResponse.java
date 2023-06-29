package com.rest.api.tutorial.domains;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberResponse {
  private int id;
  private String firstName;
  private String lastName;
}
