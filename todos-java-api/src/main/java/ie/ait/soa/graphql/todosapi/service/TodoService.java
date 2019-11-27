package ie.ait.soa.graphql.todosapi.service;

import static java.util.Optional.ofNullable;
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

  TodoService(final TodoRepository todoRepository, final Logger logger) {
    this.todoRepository = todoRepository;
    this.logger = logger;
  }

  @Transactional
  public Todo createTodo(final String text) {
    logger.info("{}.createTodo called with text = {}", this.getClass().getSimpleName(), text);
    return todoRepository.save(new Todo(text));
  }

  public Optional<Todo> deleteTodoById(final Long id) {
    logger.info("{}.deleteTodo called with id = {}", this.getClass().getSimpleName(), id);
    return todoRepository
        .findById(id)
        .map(this::deleteAndReturnTodo);
  }

  private Todo deleteAndReturnTodo(Todo todo) {
    todoRepository.delete(todo);
    return todo;
  }

  @Transactional
  public Optional<Todo> toggleTodoCompletedById(final Long id) {
    logger.info("{}.toggleTodoCompleted called with id = {}", this.getClass().getSimpleName(), id);
    return todoRepository
        .findById(id)
        .map(Todo::toggleCompleted);
  }

  @Transactional(readOnly = true)
  public Optional<Todo> getTodo(final Long id) {
    logger.info("{}.getTodo called with id = {}", this.getClass().getSimpleName(), id);
    return todoRepository.findById(id);
  }

  @Transactional(readOnly = true)
  public List<Todo> getTodos(final Long limit) {
    logger.info("{}.getTodos called with limit = {}", this.getClass().getSimpleName(), limit);
    return todoRepository.findAll()
        .stream()
        .limit(ofNullable(limit).isPresent() ? limit : Long.MAX_VALUE)
        .collect(toList());
  }

}
