package kwon.springboottodoapplication.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "todo_item")
@Data
@NoArgsConstructor
public class TodoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;

    private boolean complete;

    private Instant createdDate;

    private Instant modifiedDate;

    public TodoItem(String description) {
        this.description = description;
        this.complete = false;
        this.createdDate = Instant.now();
        this.modifiedDate = Instant.now();
    }

    @Override
    public String toString() {
        return String.format("TodoItem {id = %d, description = %s, createdDate = %s, modifiedDate = %s}",
                id, description, createdDate.toString(), modifiedDate.toString());
    }
}
