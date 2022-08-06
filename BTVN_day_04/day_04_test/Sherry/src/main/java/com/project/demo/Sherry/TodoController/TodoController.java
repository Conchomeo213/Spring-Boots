package com.project.demo.Sherry.TodoController;

import com.project.demo.Sherry.Request.CreateTodoRequest;
import com.project.demo.Sherry.Request.UpdateRequest;
import com.project.demo.Sherry.TodoModel.TodoModel;
import com.project.demo.Sherry.TodoService.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("")
    public ResponseEntity<?>getListTodo(){
        List<TodoModel> todoModels =todoService.getTodo();
        return ResponseEntity.ok(todoModels);
    }
    @GetMapping("/todo")
    public ResponseEntity<?> todoStatus(@RequestParam(value = "status",required = false,defaultValue = "") boolean status){
        List<TodoModel> todoModels = todoService.todoStatus(status);
        return ResponseEntity.ok(todoModels);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getTodoById (@PathVariable("id") int id){
        TodoModel todoModel = todoService.getTodoByID(id);
       return ResponseEntity.ok(todoModel);
    }
    @PostMapping("")
    public ResponseEntity<?> createTodo(@RequestBody CreateTodoRequest req){
        TodoModel resutl =todoService.createTodo(req) ;
        return ResponseEntity.ok(resutl);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateTodo(@RequestBody UpdateRequest req, @PathVariable int id){
        TodoModel result= todoService.updateTodo(req, id);
        return ResponseEntity.ok(result);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable int id){
      todoService.deleteTodo(id);
      return ResponseEntity.ok("Đã xóa thành công id : " + id);
    }
}
