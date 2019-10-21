package ie.ait.soa.rest.todoapi.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Todo implements Serializable {

  @Id
  @GeneratedValue
  private long id;
  private String text;
  private boolean completed;

  public Todo() {}
  public Todo(final String text) { this.text = text; }

  public long getId() { return id; }

  public Todo setId(final long id) {
    this.id = id;
    return this;
  }

  public String getText() { return text; }

  public Todo setText(final String text) {
    this.text = text;
    return this;
  }

  public boolean isCompleted() { return completed; }

  public Todo toggleCompleted() {
    completed = !completed;
    return this;
  }

}
