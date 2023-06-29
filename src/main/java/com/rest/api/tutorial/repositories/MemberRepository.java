package com.rest.api.tutorial.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rest.api.tutorial.domains.MemberResponse;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

  private final MemberMapper memberMapper;

  public List<MemberResponse> fetchMembers() {
    return memberMapper.fetchMembers();
  }

  public MemberResponse findMemberById(int id) {
    return memberMapper.findById(id);
  }
}
