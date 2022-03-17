package ie.ait.soa.graphql.todosapi.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
@Builder
@Entity
public class Todo implements Serializable {

  @Id
  @GeneratedValue
  private Long id;
  @Builder.Default private String text = "";
  @Builder.Default private Boolean completed = false;

  public Todo() {}

  public Todo toggle() {
    completed = !completed;
    return this;
  }

}
