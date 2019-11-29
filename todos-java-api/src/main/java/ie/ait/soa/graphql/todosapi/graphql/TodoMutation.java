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

  TodoMutation(TodoService todoService) { this.todoService = todoService; }

  public Todo createTodo(String text) { return todoService.createTodo(text); }

  public Optional<Todo> toggleTodoCompleted(Long id) {
    return todoService.toggleTodoCompletedById(id);
  }

  public Optional<Todo> deleteTodo(Long id) {
    return todoService.deleteTodoById(id);
  }

  public List<Todo> deleteAllTodos() {
    return todoService.deleteAllTodos();
  }
}
