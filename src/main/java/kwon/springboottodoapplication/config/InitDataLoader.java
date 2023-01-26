package kwon.springboottodoapplication.config;

import kwon.springboottodoapplication.data.TodoItem;
import kwon.springboottodoapplication.data.TodoItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class InitDataLoader implements CommandLineRunner {

    private final TodoItemRepository todoItemRepository;

    @Override
    public void run(String... args) throws Exception {
        loadSeedData();
    }

    // Running application, load Default to-do data
    private void loadSeedData() {
        if (todoItemRepository.count() == 0) {
            TodoItem todoItem1 = new TodoItem();
            todoItem1.setDescription("수영하기");
            TodoItem todoItem2 = new TodoItem();
            todoItem2.setDescription("공부하기");
            todoItemRepository.save(todoItem1);
            todoItemRepository.save(todoItem2);
        }

        log.info("Number of TodoItems : {}", todoItemRepository.count());
    }
}
