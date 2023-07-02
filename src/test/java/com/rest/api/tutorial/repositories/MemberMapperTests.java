package com.rest.api.tutorial.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import com.rest.api.tutorial.domains.MemberResponse;
import com.rest.api.tutorial.helpers.PostgresTestContainerInitializer;

@MybatisTest
@TestInstance(Lifecycle.PER_CLASS)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MemberMapperTests extends PostgresTestContainerInitializer {

  private static final int TEST_DATA_ID_1 = 1;
  private static final int TEST_DATA_ID_2 = 2;
  @Autowired
  private MemberMapper memberMapper;

  @Test
  void fetchAllTest() {
    List<MemberResponse> expectedResponses = List
        .of(new MemberResponse(TEST_DATA_ID_1, "hogeta", "hogeo"),
            new MemberResponse(TEST_DATA_ID_2, "fugata", "piyoko"));
    List<MemberResponse> actualResposes = memberMapper.fetchMembers();
    assertEquals(expectedResponses, actualResposes);

  }

  @Test
  void findByIdTest() {
    MemberResponse actualResponse = memberMapper.findById(TEST_DATA_ID_1);
    assertEquals(TEST_DATA_ID_1, actualResponse.getId());
    assertEquals("hogeta", actualResponse.getFirstName());
    assertEquals("hogeo", actualResponse.getLastName());
  }
}
