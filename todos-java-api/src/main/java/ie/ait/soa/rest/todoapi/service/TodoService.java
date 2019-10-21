package ie.ait.soa.rest.todoapi.service;

import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;

import ie.ait.soa.rest.todoapi.model.Todo;
import ie.ait.soa.rest.todoapi.repository.TodoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TodoService {

  private final TodoRepository todoRepository;

  TodoService(final TodoRepository todoRepository) { this.todoRepository = todoRepository; }

  @Transactional
  public Todo createTodo(final String text) {
    return todoRepository.save(new Todo(text));
  }

  @Transactional
  public Optional<Todo> toggleTodoCompleted(final Long id) {
    return todoRepository
        .findById(id)
        .map(Todo::toggleCompleted);
  }

  @Transactional(readOnly = true)
  public Optional<Todo> getTodo(final Long id) { return todoRepository.findById(id); }

  @Transactional(readOnly = true)
  public List<Todo> getTodos(final Long limit) {
    return todoRepository.findAll()
        .stream()
        .limit(ofNullable(limit).isPresent() ? limit : Long.MAX_VALUE)
        .collect(toList());
  }

}
