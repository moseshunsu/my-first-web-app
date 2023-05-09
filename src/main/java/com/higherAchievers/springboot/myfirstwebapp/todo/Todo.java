package com.higherAchievers.springboot.myfirstwebapp.todo;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


//Database (MySQL)
//Static List of todos => Database (H2, MySQL)
@AllArgsConstructor
@Getter
@Setter
public class Todo {
    private int id;
    private String username;
    @Size(min = 10, message = "Enter at least 10 characters")
    private String description;
    private LocalDate targetDate;
    private boolean done;
}
