package ie.ait.soa.graphql.todosapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

// https://github.com/graphql-java-kickstart/graphql-spring-boot/issues/230
// https://github.com/graphql-java-kickstart/graphql-spring-boot/issues/113
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class TodosApplicationTests {

  @Test
  void contextLoads() {
  }

}
