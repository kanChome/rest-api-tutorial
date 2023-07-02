package com.rest.api.tutorial.helpers;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.BindMode;
import org.testcontainers.containers.PostgreSQLContainer;

public abstract class PostgresTestContainerInitializer {
  private static final PostgreSQLContainer<?> POSTGRE_SQL_CONTAINER;

  private static final String POSTGRE_SQL_IMAGE = "postgres:12.11";

  private static final String INIT_SQL_RESOURCE_PATH = "sql/init.sql";
  private static final String INIT_SQL_CONTAINER_PATH = "/docker-entrypoint-initdb.d/init.sql";

  static {
    POSTGRE_SQL_CONTAINER = new PostgreSQLContainer<>(POSTGRE_SQL_IMAGE).withClasspathResourceMapping(
        INIT_SQL_RESOURCE_PATH,
        INIT_SQL_CONTAINER_PATH, BindMode.READ_ONLY);
    POSTGRE_SQL_CONTAINER.start();
  }

  @DynamicPropertySource
  static void overrideTestProperties(DynamicPropertyRegistry registry) {
    registry.add("spring.datasource.url", POSTGRE_SQL_CONTAINER::getJdbcUrl);
    registry.add("spring.datasource.username", POSTGRE_SQL_CONTAINER::getUsername);
    registry.add("spring.datasource.password", POSTGRE_SQL_CONTAINER::getPassword);
  }
}
