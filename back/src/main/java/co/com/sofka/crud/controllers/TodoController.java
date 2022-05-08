package co.com.sofka.crud.controllers;

import co.com.sofka.crud.entities.TodoEntity;
import co.com.sofka.crud.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/${config.project.version}")
@CrossOrigin(origins = "${config.cross.origin}")
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping(value = "/todo")
    public Iterable<TodoEntity> list(){
        return this.service.list();
    }
    
    @PostMapping(value = "/todo")
    public TodoEntity save(@RequestBody TodoEntity todo){
        return this.service.save(todo);
    }

    @PutMapping(value = "/todo")
    public TodoEntity update(@RequestBody TodoEntity todo){
        if(todo.getId() != null){
            return this.service.save(todo);
        }
        throw new RuntimeException("No existe el id para actualizar");
    }

    @DeleteMapping(value = "/todo/{id}")
    public void delete(@PathVariable("id")Long id){
        this.service.delete(id);
    }
}
