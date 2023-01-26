package kwon.springboottodoapplication.controllers;

import kwon.springboottodoapplication.data.TodoItem;
import kwon.springboottodoapplication.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class HomeController {

    private final TodoService todoService;

    @GetMapping("/")
    public String index(Model model) {
        log.debug( "request to GET index");

        List<TodoItem> todoItems = todoService.findAll();
        model.addAttribute("todoItems", todoItems);
        return "index";
    }
}
