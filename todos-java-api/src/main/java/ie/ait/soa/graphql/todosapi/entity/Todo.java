package ie.ait.soa.graphql.todosapi.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Todo implements Serializable {

  @Id
  @GeneratedValue
  private Long id;
  private String text = "";
  private Boolean completed = false;

  @Builder
  public Todo(String text) {
    this.text = text;
  }

  public Todo toggle() {
    completed = !completed;
    return this;
  }

}
