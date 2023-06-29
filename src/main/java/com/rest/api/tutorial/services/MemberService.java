package com.rest.api.tutorial.services;

import java.util.List;

import com.rest.api.tutorial.domains.MemberResponse;

public interface MemberService {
  public List<MemberResponse> fetchMembers();

  public MemberResponse findMember(int id);

}
