package kwon.springboottodoapplication.service;

import kwon.springboottodoapplication.data.TodoItem;
import kwon.springboottodoapplication.data.TodoItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class TodoService {

    private final TodoItemRepository todoItemRepository;

    @Transactional
    public TodoItem findById(Long id) {
        return todoItemRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Transactional
    public List<TodoItem> findAll() {
        return todoItemRepository.findAll();
    }

    @Transactional
    public Long save(TodoItem todoItem) {
        return todoItemRepository.save(todoItem).getId();
    }

    @Transactional
    public Long update(Long id, TodoItem todoItem) {
        TodoItem todo = todoItemRepository.findById(id).orElseThrow(NoSuchElementException::new);
        todo.setDescription(todoItem.getDescription());
        todo.setComplete(todoItem.isComplete());
        return todo.getId();
    }

    @Transactional
    public Long delete(Long id) {
        TodoItem todoItem = todoItemRepository.findById(id).orElseThrow(NoSuchElementException::new);
        todoItemRepository.delete(todoItem);
        return todoItem.getId();
    }
}
