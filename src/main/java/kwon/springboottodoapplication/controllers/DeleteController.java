package kwon.springboottodoapplication.controllers;

import kwon.springboottodoapplication.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class DeleteController {

    private final TodoService todoService;

    @GetMapping("/delete/{id}")
    public String deleteTodoItem(@PathVariable Long id) {
        todoService.delete(id);
        return "redirect:/";
    }
}
