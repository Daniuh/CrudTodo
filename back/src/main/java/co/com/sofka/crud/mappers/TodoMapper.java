package co.com.sofka.crud.mappers;

import co.com.sofka.crud.dtos.TodoDTO;
import co.com.sofka.crud.entities.TodoEntity;

public class TodoMapper {
    public static TodoDTO toDTO(TodoEntity todoEntity){
        TodoDTO todoDTO = new TodoDTO();
        todoDTO.setId(todoEntity.getId());
        todoDTO.setLabel(todoEntity.getLabel());
        todoDTO.setIsCompleted(todoEntity.getIsCompleted());
        todoDTO.setListId(todoEntity.getListId());
        return todoDTO;
    }

    public static TodoEntity toEntity(TodoDTO todoDTO){
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setId(todoDTO.getId());
        todoEntity.setLabel(todoDTO.getLabel());
        todoEntity.setIsCompleted(todoDTO.getIsCompleted());
        todoEntity.setListId(todoDTO.getListId());
        return todoEntity;
    }
}
