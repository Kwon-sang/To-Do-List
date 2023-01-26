package kwon.springboottodoapplication.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {
}
