package ie.ait.soa.graphql.todosapi.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import ie.ait.soa.graphql.todosapi.model.Todo;
import ie.ait.soa.graphql.todosapi.service.TodoService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class TodoQuery implements GraphQLQueryResolver {

  private final TodoService todoService;

  TodoQuery(final TodoService todoService) { this.todoService = todoService; }

  public Optional<Todo> getTodo(final Long id) { return todoService.getTodo(id); }

  public List<Todo> getTodos(final Long limit) { return todoService.getTodos(limit); }

}
