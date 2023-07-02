package com.rest.api.tutorial.repositories;

import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 不要なコンポーネントが読み込まれないように、テストクラスと同じ階層にSpringBootApplicationクラスを作成
 * 
 * http://mybatis.org/spring-boot-starter/mybatis-spring-boot-test-autoconfigure/#prevent-detecting-a-real-springbootapplication
 */
@SpringBootApplication
class MapperTestApplication {
}