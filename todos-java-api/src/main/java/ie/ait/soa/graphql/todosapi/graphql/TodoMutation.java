package ie.ait.soa.graphql.todosapi.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import ie.ait.soa.graphql.todosapi.model.Todo;
import ie.ait.soa.graphql.todosapi.service.TodoService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class TodoMutation implements GraphQLMutationResolver {

  private final TodoService todoService;

  TodoMutation(final TodoService todoService) { this.todoService = todoService; }

  public Todo createTodo(final String text) { return todoService.createTodo(text); }

  public Optional<Todo> toggleTodoCompleted(final Long id) {
    return todoService.toggleTodoCompletedById(id);
  }

  public Optional<Todo> deleteTodo(final Long id) {
    return todoService.deleteTodoById(id);
  }

  public List<Todo> deleteAllTodos() {
    return todoService.deleteAllTodos();
  }
}
