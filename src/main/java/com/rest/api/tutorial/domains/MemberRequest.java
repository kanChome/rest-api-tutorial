package com.rest.api.tutorial.domains;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MemberRequest {
  private String id;
  private String firstName;
  private String lastName;
}
