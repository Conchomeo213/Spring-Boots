package com.project.demo.Sherry.TodoModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class TodoModel {
    private int id;
    private String title;
    private boolean status;
}
