package com.rest.api.tutorial.repositories;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.rest.api.tutorial.domains.MemberResponse;

@Mapper
interface MemberMapper {

  @Select("SELECT id, first_name, last_Name FROM member")
  List<MemberResponse> fetchMembers();

  @Select("SELECT id, first_name, last_name FROM member WHERE id = #{id}")
  MemberResponse findById(@Param("id") int id);
}
