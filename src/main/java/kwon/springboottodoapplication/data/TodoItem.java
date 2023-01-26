package kwon.springboottodoapplication.data;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;


@Data
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@Entity(name = "todo_item")
public class TodoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank(message = "내용을 작성하십시오.")
    private String description;

    @Getter
    private boolean complete = false;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

    @Override
    public String toString() {
        return String.format("TodoItem {id = %d, description = %s, createdDate = %s, modifiedDate = %s}",
                id, description, createdDate.toString(), modifiedDate.toString());
    }
}
