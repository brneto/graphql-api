package ie.ait.soa.rest.todoapi.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import ie.ait.soa.rest.todoapi.model.Todo;
import ie.ait.soa.rest.todoapi.service.TodoService;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class TodoMutation implements GraphQLMutationResolver {

  private final TodoService todoService;

  TodoMutation(final TodoService todoService) { this.todoService = todoService; }

  public Todo createTodo(final String text) { return todoService.createTodo(text); }

  public Optional<Todo> toggleTodoCompleted(final Long id) {
    return todoService.toggleTodoCompleted(id);
  }
}
