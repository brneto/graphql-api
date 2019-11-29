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
  public Todo createTodo(final String text) {
    logger.info("{}.createTodo called with text = {}", className, text);
    return todoRepository.save(new Todo(text));
  }

  @Transactional
  public List<Todo> deleteAllTodos() {
    logger.info("{}.deleteAllTodos called", className);

    List<Todo> todoList = getTodos(empty());
    todoRepository.deleteAll();
    return todoList;
  }

  @Transactional
  public Optional<Todo> deleteTodoById(Long id) {
    logger.info("{}.deleteTodo called with id = {}", className, id);
    return getTodo(id).map(this::deleteTodo);
  }

  private Todo deleteTodo(Todo todo) {
    todoRepository.delete(todo);
    return todo;
  }

  @Transactional
  public Optional<Todo> toggleTodoCompletedById(Long id) {
    logger.info("{}.toggleTodoCompleted called with id = {}", className, id);
    return getTodo(id).map(Todo::toggleCompleted);
  }

  @Transactional(readOnly = true)
  public Optional<Todo> getTodo(Long id) {
    logger.info("{}.getTodo called with id = {}", className, id);
    return todoRepository.findById(id);
  }

  @Transactional(readOnly = true)
  public List<Todo> getTodos(Optional<Long> limit) {
    logger.info("{}.getTodos called with limit = {}", className,
        limit.isPresent() ? limit.get() : "empty");

    return todoRepository.findAll()
        .stream()
        .limit(limit
                .filter(l -> l > 0)
                .orElse(Long.MAX_VALUE))
        .collect(toList());
  }

}
