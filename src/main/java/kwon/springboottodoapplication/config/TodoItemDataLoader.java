package kwon.springboottodoapplication.config;

import kwon.springboottodoapplication.models.TodoItem;
import kwon.springboottodoapplication.repositories.TodoItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TodoItemDataLoader implements CommandLineRunner {
    private final Logger logger = LoggerFactory.getLogger(TodoItemDataLoader.class);

    @Autowired
    TodoItemRepository todoItemRepository;

    @Override
    public void run(String... args) throws Exception {
        loadSeedData();
    }

    private void loadSeedData() {
        //The CrudRepository count() method returns the number of entities available in database.
        if (todoItemRepository.count() == 0) {
            TodoItem todoItem1 = new TodoItem("go to swimming pool");
            TodoItem todoItem2 = new TodoItem("study algorithms");

            todoItemRepository.save(todoItem1);
            todoItemRepository.save(todoItem2);
        }

        logger.info("Number of TodoItems : {}", todoItemRepository.count());
    }
}
