package com.project.demo.Sherry.TodoService;

import com.project.demo.Sherry.Request.CreateTodoRequest;
import com.project.demo.Sherry.Request.UpdateRequest;
import com.project.demo.Sherry.TodoModel.TodoModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Service1 {
    public List<TodoModel> todoStatus(Boolean status);


    public List<TodoModel> getTodo();

    public TodoModel getTodoByID(int id);

    public TodoModel createTodo(CreateTodoRequest req);

    public TodoModel updateTodo(UpdateRequest req, int id);

    public boolean deleteTodo(int id);
}
