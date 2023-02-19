package com.sh.controllers;

import com.sh.payload.ResponseBean;
import com.sh.responses.TodoInfo;
import com.sh.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping("/{id}")
    public @ResponseBody ResponseEntity<ResponseBean<TodoInfo>> getTodoById(@PathVariable Long id) {
        ResponseBean<TodoInfo> response = todoService.findTodoById(id);
        return new ResponseEntity<>(response,
                ResponseBean.SUCCESS.equals(response.getStatus()) ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/all")
    public @ResponseBody ResponseEntity<List<TodoInfo>> getAllTodos() {
        List<TodoInfo> todos = todoService.getAllTodos();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }


    @PostMapping("/")
    public @ResponseBody ResponseEntity<ResponseBean<TodoInfo>> createTodo(@RequestBody TodoInfo todo) {
        ResponseBean<TodoInfo> response = todoService.createTodo(todo);
        return new ResponseEntity<>(response,
                ResponseBean.SUCCESS.equals(response.getStatus()) ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }


    @PutMapping("/")
    public @ResponseBody ResponseEntity<ResponseBean<TodoInfo>> updateTodo(
            @RequestBody TodoInfo todo) {
        ResponseBean<TodoInfo> response = todoService.updateTodo(todo);
        return new ResponseEntity<>(response,
                ResponseBean.SUCCESS.equals(response.getStatus()) ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody ResponseEntity<ResponseBean<TodoInfo>> deleteTodo(@PathVariable Long id) {
        ResponseBean<TodoInfo> response = todoService.deleteTodo(id);
        return new ResponseEntity<>(response,
                ResponseBean.SUCCESS.equals(response.getStatus()) ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/allByInCompleted")
    public @ResponseBody ResponseEntity<List<TodoInfo>> getAllTodosCompleted() {
        List<TodoInfo> todos = todoService.getAllTodosCompleted();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    @PostMapping("/allByCompleted")
    public @ResponseBody ResponseEntity<List<TodoInfo>> getAllTodosInCompleted() {
        List<TodoInfo> todos = todoService.getAllTodosInCompleted();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

}
