package co.com.sofka.crud.services;

import co.com.sofka.crud.dtos.ListDTO;
import co.com.sofka.crud.entities.ListEntity;
import co.com.sofka.crud.entities.TodoEntity;
import co.com.sofka.crud.mappers.ListMapper;
import co.com.sofka.crud.repositories.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListService {

    @Autowired
    private ListRepository repository;

    @Autowired
    private TodoService todoService;

    public Iterable<ListDTO> list() {
        List<ListDTO> listDTOS = new ArrayList<>();

        this.repository.findAll().forEach(listEntity -> {
            Iterable<TodoEntity> todoEntities = todoService.getByListId(listEntity.getId());
            listDTOS.add(ListMapper.toDTO(listEntity, todoEntities));
        });

        return listDTOS;
    }

    public ListEntity save(ListEntity todo){
        return this.repository.save(todo);
    }

    public void delete(String id){
        this.repository.delete(get(id));
    }

    public ListEntity get(String id){
        return this.repository.findById(id).orElseThrow();
    }
}