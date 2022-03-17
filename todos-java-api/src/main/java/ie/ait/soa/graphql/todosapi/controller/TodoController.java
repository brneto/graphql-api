package ie.ait.soa.graphql.todosapi.controller;

import ie.ait.soa.graphql.todosapi.entity.Todo;
import ie.ait.soa.graphql.todosapi.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @QueryMapping
    public Optional<Todo> todo(@Argument Long id) {
        System.out.println("call this getTodo");
        return todoService.getTodo(id);
    }

    @QueryMapping
    public List<Todo> todos(@Argument Integer count) {
        return todoService.getTodos(count.longValue());
    }

    @MutationMapping
    public Todo createTodo(@Argument String text) {
        return todoService.createTodo(text);
    }

    @MutationMapping
    public Optional<Todo> toggleTodo(@Argument Long id) {
        return todoService.toggleTodoById(id);
    }

    @MutationMapping
    public Optional<Todo> deleteTodo(@Argument Long id) {
        return todoService.deleteTodoById(id);
    }

    @MutationMapping
    public List<Todo> deleteAllTodos() {
        return todoService.deleteAllTodos();
    }
}
