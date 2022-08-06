package com.project.demo.Sherry.TodoService;

import com.project.demo.Sherry.Request.CreateTodoRequest;
import com.project.demo.Sherry.Request.UpdateRequest;
import com.project.demo.Sherry.TodoModel.TodoModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class TodoService implements Service1 {
    public  List<TodoModel> todo = new ArrayList<>(List.of(
            new TodoModel(1, "Đi đá bóng", true),
            new TodoModel(2, "Làm bài tập", false),
            new TodoModel(3, "Đi chơi với bạn bè", true)
    ));

    @Override
    public List<TodoModel> todoStatus(Boolean status) {
        List<TodoModel> result = new ArrayList<>();
        for (TodoModel todoModel : todo){
            if (todoModel.isStatus()==status){
                result.add(todoModel);
            }
        }
        return result;
    }

    @Override
    public List<TodoModel> getTodo() {

        List<TodoModel> result = new ArrayList<>();
        for (TodoModel todoModel : todo){
            result.add(todoModel);
        }
        return result;
    }

    @Override
    public TodoModel getTodoByID(int id) {
        for (TodoModel todoModel : todo){
            if (todoModel.getId()==id){
                return todoModel;
            }
        }
        return null;
    }

    @Override
    public TodoModel createTodo(CreateTodoRequest req) {
        Random rd = new Random();
        TodoModel todoModel =new TodoModel();
        todoModel.setId(rd.nextInt(10));
        todoModel.setTitle(req.getTitle());
        todoModel.setStatus(false);
        todo.add(todoModel);
        return todoModel;
    }

    @Override
    public TodoModel updateTodo(UpdateRequest req, int id){
        for (TodoModel todoModel : todo){
            if (todoModel.getId()==id){
           todoModel.setTitle(req.getTitle());
           todoModel.setStatus(req.getStatus());
           return todoModel;
            }
        }
        return null;
    }

    @Override
    public boolean deleteTodo(int id) {
        for (TodoModel todoModel : todo){
            if (todoModel.getId()==id){
                todo.remove(todoModel);
                return true;
            }
        }
        return false;
    }
}
