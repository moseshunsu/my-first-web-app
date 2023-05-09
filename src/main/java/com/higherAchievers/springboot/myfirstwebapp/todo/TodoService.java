package com.higherAchievers.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    private static int todoCount = 0;
    private static List<Todo> todos = new ArrayList<>();

    static {
        todos.add(new Todo(++todoCount, "higherAchievers", "Learn AWS",
                LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todoCount, "higherAchievers", "Learn DevOops",
                LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todoCount, "higherAchievers", "Learn Full Stack Development",
                LocalDate.now().plusYears(1), false));
    }

    public List<Todo> findByUsername(String username) {
        return todos;
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
        Todo todo = new Todo(++todoCount, username, description, targetDate, done);
        todos.add(todo);
    }
}
