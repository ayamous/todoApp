package com.sh.repository;

import com.sh.entities.Todo;
import com.sh.util.TodoStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository  extends JpaRepository<Todo, Long> {

    List<Todo> findByStatusNot(TodoStatus status);
}
