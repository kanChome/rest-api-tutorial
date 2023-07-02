package com.rest.api.tutorial.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rest.api.tutorial.domains.MemberRequest;
import com.rest.api.tutorial.domains.MemberResponse;
import com.rest.api.tutorial.services.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/member")
public class MemberController {

  private final MemberService memberService;

  /**
   * ユーザー全件取得
   */
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<MemberResponse> fetchMembers() {
    return memberService.fetchMembers();
  }

  /**
   * IDに紐づくユーザー取得
   */
  @GetMapping("/{memberId}")
  @ResponseStatus(HttpStatus.OK)
  public MemberResponse findMember(@PathVariable int memberId) {
    return memberService.findMember(memberId);
  }

  /**
   * ユーザー登録
   */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void registerMember(@Validated @RequestBody MemberRequest request) {
    memberService.registerMember(request);
  }

  /**
   * ユーザー更新
   */
  @PutMapping("/{memberId}")
  public void updateMember() {

  }

  /**
   * ユーザー削除
   */
  @DeleteMapping("/{memberId}")
  public void deleteMember() {

  }
}
