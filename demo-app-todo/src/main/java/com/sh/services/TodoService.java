package com.sh.services;

import com.sh.payload.ResponseBean;
import com.sh.responses.TodoInfo;

import java.util.List;

public interface TodoService {
    ResponseBean<TodoInfo> createTodo(TodoInfo todo);

    ResponseBean<TodoInfo> updateTodo(TodoInfo todo);

    ResponseBean<TodoInfo> findTodoById(Long id);

    ResponseBean<TodoInfo> deleteTodo(Long id);

    List<TodoInfo> getAllTodos();

    List<TodoInfo> getAllTodosInCompleted();

    List<TodoInfo> getAllTodosCompleted();


}
