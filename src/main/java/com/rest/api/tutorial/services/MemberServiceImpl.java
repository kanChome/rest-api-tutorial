package com.rest.api.tutorial.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.api.tutorial.domains.MemberRequest;
import com.rest.api.tutorial.domains.MemberResponse;
import com.rest.api.tutorial.repositories.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
class MemberServiceImpl implements MemberService {

  private final MemberRepository memberRepository;

  @Override
  @Transactional(readOnly = true)
  public List<MemberResponse> fetchMembers() {
    return memberRepository.fetchMembers();
  }

  @Override
  @Transactional(readOnly = true)
  public MemberResponse findMember(int id) {
    return memberRepository.findMemberById(id);
  }

  @Override
  public void registerMember(MemberRequest member) {
    memberRepository.registerMember(member);
  }

}
