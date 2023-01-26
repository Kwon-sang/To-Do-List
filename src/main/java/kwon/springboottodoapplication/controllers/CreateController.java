package kwon.springboottodoapplication.controllers;

import kwon.springboottodoapplication.data.TodoItem;
import kwon.springboottodoapplication.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
public class CreateController {

    private final TodoService todoService;

    @GetMapping("/create-todo")
    public String showCreateForm(TodoItem todoItem) {
        return "add-todo-item";
    }

    @PostMapping("/todo")
    public String saveTodoItem(@Valid TodoItem todoItem, Errors errors) {
        if (errors.hasErrors()) {
            return "add-todo-item";
        }
        todoService.save(todoItem);
        return "redirect:/";
    }
}
