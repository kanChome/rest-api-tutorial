package com.rest.api.tutorial.repositories;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.rest.api.tutorial.domains.MemberRequest;
import com.rest.api.tutorial.domains.MemberResponse;

@Mapper
interface MemberMapper {

  @Select("SELECT id, first_name, last_Name FROM member")
  List<MemberResponse> fetchMembers();

  @Select("SELECT id, first_name, last_name FROM member WHERE id = #{id}")
  MemberResponse findById(@Param("id") int id);

  @Insert("INSERT INTO public.member(first_name, last_name)"
      + " VALUES ("
      + "  #{member.firstName},"
      + "  #{member.lastName}"
      + " )")
  void insertMember(@Param("member") MemberRequest member);

  @Update("UPDATE public.member "
      + "SET "
      + "  first_name = #{member.firstName}, "
      + "  last_name = #{member.lastName} "
      + "WHERE "
      + "  id = #{id}")
  void updateMember(@Param("id") int id, @Param("member") MemberRequest member);

  @Delete("DELETE FROM public.member WHERE id = #{id}")
  void deleteMember(@Param("id") int id);
}
