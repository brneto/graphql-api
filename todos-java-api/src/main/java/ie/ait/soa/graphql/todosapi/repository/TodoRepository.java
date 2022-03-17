package ie.ait.soa.graphql.todosapi.repository;

import ie.ait.soa.graphql.todosapi.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
