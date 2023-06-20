package com.rest.api.tutorial.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
public class UserController {

  /**
   * ユーザー全件取得
   */
  @GetMapping
  public void fetchAllUsers() {

  }

  /**
   * IDに紐づくユーザー取得
   */
  @GetMapping("/{userId}")
  public void findUser() {

  }

  /**
   * ユーザー登録
   */
  @PostMapping
  public void registerUser() {

  }

  /**
   * ユーザー更新
   */
  @PutMapping("/{userId}")
  public void updateUser() {

  }

  @DeleteMapping("/{userId}")
  public void deleteUser() {

  }
}
