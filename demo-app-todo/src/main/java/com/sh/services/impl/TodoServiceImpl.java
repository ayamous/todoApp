package com.sh.services.impl;

import com.sh.entities.Todo;
import com.sh.mapper.TodoMapper;
import com.sh.payload.ResponseBean;
import com.sh.repository.TodoRepository;
import com.sh.responses.TodoInfo;
import com.sh.services.TodoService;
import com.sh.util.TodoStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;
    private TodoMapper todoMapper;
    private static final String TODO_NOT_FOUND = "Identifiant d todo inexistant";

    @Autowired
    public TodoServiceImpl(TodoRepository todoRepository, TodoMapper todoMapper) {
        this.todoRepository = todoRepository;
        this.todoMapper = todoMapper;
    }


    @Override
    public ResponseBean<TodoInfo> createTodo(TodoInfo todo) {
        ResponseBean<TodoInfo> response = new ResponseBean<>(ResponseBean.SUCCESS, "Todo a été crée avec succès");
        Todo savedTodo = todoMapper.modelToEntity(todo);
        savedTodo = todoRepository.save(savedTodo);
        response.setContent(todoMapper.entityToModel(savedTodo));
        return response;
    }


    @Override
    public ResponseBean<TodoInfo> updateTodo(TodoInfo todo) {
        ResponseBean<TodoInfo> response = new ResponseBean<>(ResponseBean.SUCCESS,"Todo a étée modifié avec succès");
        if (todo.getId() != null) {
            Optional<Todo> persisted = todoRepository.findById(todo.getId());

            persisted.ifPresent(p -> {
                Todo toMerge = todoMapper.modelToEntity(todo);
                Todo savedTodo = todoRepository.save(toMerge);
                TodoInfo todoInfo = todoMapper.entityToModel(savedTodo);
                response.setContent(todoInfo);
            });

            if (!persisted.isPresent()) {
                response.setStatus(ResponseBean.ERROR);
                response.setMessage(TODO_NOT_FOUND);
            }

        } else {
            response.setStatus(ResponseBean.ERROR);
            response.setMessage("Identifiant du todo invalide");
        }
        return response;
    }

    @Override
    public ResponseBean<TodoInfo> deleteTodo(Long id) {
        ResponseBean<TodoInfo> response = new ResponseBean<>(ResponseBean.SUCCESS,"Todo a été supprimé avec succès");
        Optional<Todo> todo = todoRepository.findById(id);
        todo.ifPresent(s -> todoRepository.delete(s));
        if (!todo.isPresent()) {
            response.setStatus(ResponseBean.ERROR);
            response.setMessage("Erreur lors de la suppression d todo");
        }
        return response;
    }

    @Override
    public ResponseBean<TodoInfo> findTodoById(Long id) {
        ResponseBean<TodoInfo> response = new ResponseBean<>(ResponseBean.SUCCESS, "");
        Optional<Todo> todo = todoRepository.findById(id);
        todo.ifPresent(s -> {
            TodoInfo todoInfo = todoMapper.entityToModel(s);
            response.setContent(todoInfo);
        });
        if (!todo.isPresent()) {
            response.setStatus(ResponseBean.ERROR);
            response.setMessage(TODO_NOT_FOUND);
        }
        return response;
    }

    @Override
    public List<TodoInfo> getAllTodos() {
        return todoMapper.entitiesToModels(todoRepository.findAll());
    }

    @Override
    public List<TodoInfo> getAllTodosCompleted() {
        return todoMapper.entitiesToModels(todoRepository.findByStatusNot(TodoStatus.COMPLETED));
    }

    @Override
    public List<TodoInfo> getAllTodosInCompleted() {
        return todoMapper.entitiesToModels(todoRepository.findByStatusNot(TodoStatus.INCOMPLETED));
    }


}
