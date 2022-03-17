package ie.ait.soa.graphql.todosapi.service;

import ie.ait.soa.graphql.todosapi.model.Todo;
import ie.ait.soa.graphql.todosapi.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
@Slf4j
@RequiredArgsConstructor
public class TodoService {

  private final TodoRepository todoRepository;

  @Transactional
  public Todo createTodo(String text) {
    log.info("createTodo({}) called", text);
    return todoRepository.save(new Todo(text));
  }

  @Transactional
  public List<Todo> deleteAllTodos() {
    log.info("deleteAllTodos() called");

    List<Todo> todoList = getTodos(0L);
    todoRepository.deleteAll();
    return todoList;
  }

  @Transactional
  public Optional<Todo> deleteTodoById(Long id) {
    log.info("deleteTodo({}) called", id);
    return getTodo(id).map(this::deleteTodo);
  }

  private Todo deleteTodo(Todo todo) {
    todoRepository.delete(todo);
    return todo;
  }

  @Transactional
  public Optional<Todo> toggleTodoCompletedById(Long id) {
    log.info("toggleTodoCompleted({}) called", id);
    return getTodo(id).map(Todo::toggleCompleted);
  }

  @Transactional(readOnly = true)
  public Optional<Todo> getTodo(Long id) {
    log.info("getTodo({}) called", id);
    return todoRepository.findById(id);
  }

  @Transactional(readOnly = true)
  public List<Todo> getTodos(Long limit) {
    log.info("getTodos({}) called", limit);
    return todoRepository.findAll()
        .stream()
        .limit(limit > 0 ? limit : Long.MAX_VALUE)
        .collect(toList());
  }

}
