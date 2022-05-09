package co.com.sofka.crud.mappers;

import co.com.sofka.crud.dtos.ListDTO;
import co.com.sofka.crud.dtos.TodoDTO;
import co.com.sofka.crud.entities.ListEntity;
import co.com.sofka.crud.entities.TodoEntity;

import java.util.ArrayList;
import java.util.List;

public class ListMapper {
    public static ListDTO toDTO(ListEntity listEntity, Iterable<TodoEntity> todoEntities){
        ListDTO listDTO = new ListDTO();
        List<TodoDTO> todoDTOS = new ArrayList<>();
        todoEntities.forEach(todoEntity -> todoDTOS.add(TodoMapper.toDTO(todoEntity)));
        listDTO.setId(listEntity.getId());
        listDTO.setLabel(listEntity.getLabel());
        listDTO.setTodos(todoDTOS);
        return listDTO;
    }

    public static ListEntity toEntity(ListDTO listDTO){
        ListEntity listEntity = new ListEntity();
        listEntity.setId(listDTO.getId());
        listEntity.setLabel(listDTO.getLabel());

        return listEntity;
    }
}
