package co.com.sofka.crud.services;

import co.com.sofka.crud.entities.TodoEntity;
import co.com.sofka.crud.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    public TodoEntity save(TodoEntity todo){
        return this.repository.save(todo);
    }

    public void delete(String id){
        this.repository.delete(get(id));
    }

    public TodoEntity get(String id){
         return this.repository.findById(id).orElseThrow();
    }

    public Iterable<TodoEntity> getByListId(String listId){
        return this.repository.findByListId(listId);
    }
}
