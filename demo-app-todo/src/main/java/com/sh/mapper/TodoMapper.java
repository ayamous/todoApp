package com.sh.mapper;

import com.sh.entities.Todo;
import com.sh.responses.TodoInfo;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TodoMapper {
    TodoInfo entityToModel(Todo source);

    Todo modelToEntity(TodoInfo destination);

    @IterableMapping(qualifiedByName = "entityToModel")
    List<TodoInfo> entitiesToModels(List<Todo> todos);
}
