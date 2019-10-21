package ie.ait.soa.rest.todoapi.repository;

import ie.ait.soa.rest.todoapi.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

}
