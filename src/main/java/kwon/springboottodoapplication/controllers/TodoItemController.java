package kwon.springboottodoapplication.controllers;

import kwon.springboottodoapplication.models.TodoItem;
import kwon.springboottodoapplication.repositories.TodoItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.Instant;
import java.time.ZoneId;

@Controller
public class TodoItemController {
    private final Logger logger = LoggerFactory.getLogger(TodoItemController.class);

    @Autowired
    private TodoItemRepository todoItemRepository;

    @GetMapping("/")
    public ModelAndView index() {
        logger.debug( "request to GET index");
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("todoItems", todoItemRepository.findAll());
        modelAndView.addObject("today", Instant.now().atZone(ZoneId.systemDefault()).toLocalDateTime().getDayOfWeek());
        return modelAndView;
    }

    @PostMapping("/todo")
    public String createTodoItem(@Valid TodoItem todoItem, Errors errors) {
        if (errors.hasErrors()) {
            return "add-todo-item";
        }

        todoItem.setCreatedDate(Instant.now());
        todoItem.setModifiedDate(Instant.now());
        todoItemRepository.save(todoItem);
        return "redirect:/";
    }

    @PostMapping("/todo/{id}")
    public String update(@PathVariable("id") long id, @Validated TodoItem todoItem, Errors errors, Model model) {
        if (errors.hasErrors()) {
            todoItem.setId(id);
            return "update-todo-item";
        }

        todoItem.setModifiedDate(Instant.now());
        todoItemRepository.save(todoItem);

        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id, Model model) {
        TodoItem todoItem = todoItemRepository
                .findById(id)
                .orElseThrow(() -> new IllegalArgumentException("TodoItem id : " + id + " not found"));
        todoItemRepository.delete(todoItem);
        return "redirect:/";
    }
}
