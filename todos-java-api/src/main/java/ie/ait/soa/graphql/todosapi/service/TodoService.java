package ie.ait.soa.graphql.todosapi.service;

import static java.util.Optional.empty;
import static java.util.stream.Collectors.toList;

import ie.ait.soa.graphql.todosapi.model.Todo;
import ie.ait.soa.graphql.todosapi.repository.TodoRepository;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TodoService {

  private final TodoRepository todoRepository;
  private final Logger logger;
  private final String className = getClass().getSimpleName();

  TodoService(TodoRepository todoRepository, Logger logger) {
    this.todoRepository = todoRepository;
    this.logger = logger;
  }

  @Transactional
  public Todo createTodo(String text) {
    logger.info("{}.createTodo({}) called", className, text);
    return todoRepository.save(new Todo(text));
  }

  @Transactional
  public List<Todo> deleteAllTodos() {
    logger.info("{}.deleteAllTodos() called", className);

    List<Todo> todoList = getTodos(0L);
    todoRepository.deleteAll();
    return todoList;
  }

  @Transactional
  public Optional<Todo> deleteTodoById(Long id) {
    logger.info("{}.deleteTodo({}) called", className, id);
    return getTodo(id).map(this::deleteTodo);
  }

  private Todo deleteTodo(Todo todo) {
    todoRepository.delete(todo);
    return todo;
  }

  @Transactional
  public Optional<Todo> toggleTodoCompletedById(Long id) {
    logger.info("{}.toggleTodoCompleted({}) called", className, id);
    return getTodo(id).map(Todo::toggleCompleted);
  }

  @Transactional(readOnly = true)
  public Optional<Todo> getTodo(Long id) {
    logger.info("{}.getTodo({}) called", className, id);
    return todoRepository.findById(id);
  }

  @Transactional(readOnly = true)
  public List<Todo> getTodos() { return getTodos(0L); }

  @Transactional(readOnly = true)
  public List<Todo> getTodos(Long limit) {
    boolean hasLimit = limit > 0;
    String logMessage = hasLimit
          ? String.format("%s.getTodos(%d) called", className, limit)
          : String.format("%s.getTodos() called", className);

    logger.info(logMessage);

    return todoRepository.findAll()
        .stream()
        .limit(hasLimit ? limit : Long.MAX_VALUE)
        .collect(toList());
  }

}
