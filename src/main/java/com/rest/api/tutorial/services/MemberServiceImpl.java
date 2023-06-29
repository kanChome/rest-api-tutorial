package com.rest.api.tutorial.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.api.tutorial.domains.MemberResponse;
import com.rest.api.tutorial.repositories.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberServiceImpl implements MemberService {

  private final MemberRepository memberRepository;

  @Override
  @Transactional(readOnly = true)
  public List<MemberResponse> fetchMembers() {
    log.debug("test");
    return memberRepository.fetchMembers();
  }

  @Override
  @Transactional(readOnly = true)
  public MemberResponse findMember(int id) {
    return memberRepository.findMemberById(id);
  }

}
