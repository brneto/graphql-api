package ie.ait.soa.graphql.todosapi.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import ie.ait.soa.graphql.todosapi.model.Todo;
import ie.ait.soa.graphql.todosapi.service.TodoService;
import java.util.List;
import java.util.Optional;
import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

@Component
public class TodoQuery implements GraphQLQueryResolver {

  private final TodoService todoService;

  TodoQuery(TodoService todoService) { this.todoService = todoService; }

  public Optional<Todo> getTodo(Long id) { return todoService.getTodo(id); }

  public List<Todo> getTodos(Long limit) { return todoService.getTodos(limit); }

}
