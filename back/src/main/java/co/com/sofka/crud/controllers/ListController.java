package co.com.sofka.crud.controllers;

import co.com.sofka.crud.entities.ListEntity;
import co.com.sofka.crud.entities.TodoEntity;
import co.com.sofka.crud.services.ListService;
import co.com.sofka.crud.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/${config.project.version}")
@CrossOrigin(origins = "${config.cross.origin}")
public class ListController {

    @Autowired
    private ListService service;

    @GetMapping(value = "/list")
    public Iterable<ListEntity> list(){
        return this.service.list();
    }

    @PostMapping(value = "/list")
    public ListEntity save(@RequestBody ListEntity todo){
        return this.service.save(todo);
    }

    @DeleteMapping(value = "/list/{id}")
    public void delete(@PathVariable("id") Integer id){
        service.delete(id);
    }
}
