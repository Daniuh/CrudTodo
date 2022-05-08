package co.com.sofka.crud.services;

import co.com.sofka.crud.entities.TodoEntity;
import co.com.sofka.crud.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    public Iterable<TodoEntity> list(){
        return this.repository.findAll();
    }

    public TodoEntity save(TodoEntity todo){
        return this.repository.save(todo);
    }

    public void delete(Long id){
        this.repository.delete(get(id));
    }

    public TodoEntity get(Long id){
         return this.repository.findById(id).orElseThrow();
    }

}
