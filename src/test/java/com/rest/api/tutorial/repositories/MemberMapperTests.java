package com.rest.api.tutorial.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.apache.ibatis.javassist.compiler.ast.Member;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import com.rest.api.tutorial.domains.MemberRequest;
import com.rest.api.tutorial.domains.MemberResponse;
import com.rest.api.tutorial.helpers.PostgresTestContainerInitializer;

@MybatisTest
@TestInstance(Lifecycle.PER_CLASS)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MemberMapperTests extends PostgresTestContainerInitializer {

  private static final int TEST_DATA_ID_1 = 1;
  private static final int TEST_DATA_ID_2 = 2;
  private static final int TEST_DATA_ID_3 = 3;

  @Autowired
  private MemberMapper memberMapper;

  @Test
  void fetchAllTest() {
    List<MemberResponse> expectedResponses = List
        .of(new MemberResponse(TEST_DATA_ID_1, "hogeta", "hogeo"),
            new MemberResponse(TEST_DATA_ID_2, "fugata", "piyoko"));
    assertEquals(expectedResponses, memberMapper.fetchMembers());

  }

  @Test
  void findByIdTest() {
    MemberResponse actualResponse = memberMapper.findById(TEST_DATA_ID_1);
    assertEquals(TEST_DATA_ID_1, actualResponse.getId());
    assertEquals("hogeta", actualResponse.getFirstName());
    assertEquals("hogeo", actualResponse.getLastName());
  }

  @Test
  void insertTest() {
    memberMapper.insertMember(new MemberRequest("bar", "foo"));
    MemberResponse expected = new MemberResponse(3, "bar", "foo");
    assertEquals(expected, memberMapper.findById(TEST_DATA_ID_3));
  }

  @Test
  void updateTest() {
    memberMapper.updateMember(TEST_DATA_ID_2, new MemberRequest("piyopiyo", "fugafuga"));
    MemberResponse actual = memberMapper.findById(TEST_DATA_ID_2);
    assertEquals("piyopiyo", actual.getFirstName());
    assertEquals("fugafuga", actual.getLastName());
  }

  @Test
  void deleteTest() {
    memberMapper.deleteMember(TEST_DATA_ID_3);
    assertEquals(null, memberMapper.findById(TEST_DATA_ID_3));
  }
}
