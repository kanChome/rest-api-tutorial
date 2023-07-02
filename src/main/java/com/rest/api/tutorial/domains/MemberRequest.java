package com.rest.api.tutorial.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.lang.NonNull;

@Data
@AllArgsConstructor
public class MemberRequest {
  @NonNull
  private String firstName;
  @NonNull
  private String lastName;
}
