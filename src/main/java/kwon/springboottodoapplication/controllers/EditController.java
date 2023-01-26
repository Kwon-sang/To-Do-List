package kwon.springboottodoapplication.controllers;

import kwon.springboottodoapplication.data.TodoItem;
import kwon.springboottodoapplication.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class EditController {

    private final TodoService todoService;

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        TodoItem todoItem = todoService.findById(id);
        model.addAttribute("todoItem", todoItem);
        return "update-todo-item";
    }

    @PostMapping("/todo/{id}")
    public String updateTodoItem(@PathVariable Long id, @Validated TodoItem todoItem, Errors errors) {
        if (errors.hasErrors()) {
            return "update-todo-item";
        }

        todoService.update(id, todoItem);
        return "redirect:/";
    }
}
