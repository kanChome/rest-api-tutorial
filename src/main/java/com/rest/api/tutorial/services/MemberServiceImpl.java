package com.rest.api.tutorial.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.api.tutorial.domains.MemberRequest;
import com.rest.api.tutorial.domains.MemberResponse;
import com.rest.api.tutorial.exceptions.ResourceNotFoundException;
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
    return findMemberById(id).orElseThrow(ResourceNotFoundException::new);
  }

  @Override
  @Transactional
  public void registerMember(MemberRequest member) {
    memberRepository.registerMember(member);
  }

  @Override
  @Transactional
  public void updateMember(int id, MemberRequest memberRequest) {
    findMemberById(id).ifPresentOrElse(member -> memberRepository.updateMember(id, memberRequest), () -> {
      throw new ResourceNotFoundException();
    });
  }

  @Override
  @Transactional
  public void deleteMember(int id) {
    findMemberById(id).ifPresentOrElse(member -> memberRepository.deleteMember(id), () -> {
      throw new ResourceNotFoundException();
    });
  }

  private Optional<MemberResponse> findMemberById(int id) {
    MemberResponse member = memberRepository.findMemberById(id);
    return Objects.isNull(member) ? Optional.empty() : Optional.of(member);
  }
}
