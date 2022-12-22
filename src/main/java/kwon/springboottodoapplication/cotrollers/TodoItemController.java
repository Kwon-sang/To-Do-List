package kwon.springboottodoapplication.cotrollers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TodoItemController {
    private final Logger logger = LoggerFactory.getLogger(TodoItemController.class);

    @GetMapping("/")
    public String index() {
        logger.debug( "request to GET index");
        return "index";
    }
}
