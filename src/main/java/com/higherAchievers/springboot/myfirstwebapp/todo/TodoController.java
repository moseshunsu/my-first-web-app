package com.higherAchievers.springboot.myfirstwebapp.todo;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.naming.Binding;
import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @RequestMapping("/list-todos")
    public String listAllTodos(ModelMap modelMap) {
        List<Todo> todos = todoService.findByUsername("higherAchievers");
        modelMap.addAttribute("todos", todos);

        return "listTodos";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap modelMap) {
        String username = (String) modelMap.get("name");
        Todo todo = new Todo(0, username,"", LocalDate.now().plusYears(1),
                false);
        modelMap.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String addNewTodo(ModelMap modelMap, @Valid Todo todo, BindingResult result) {

        if(result.hasErrors()) {
            return "todo";
        }

        String username = (String) modelMap.get("name");
        todoService.addTodo(username, todo.getDescription(), LocalDate.now().plusYears(1),
                false);
        return "redirect:list-todos";
    }
}
