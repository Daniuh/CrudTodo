package co.com.sofka.crud.controllers;

import co.com.sofka.crud.dtos.ListDTO;
import co.com.sofka.crud.entities.ListEntity;
import co.com.sofka.crud.services.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/${config.project.version}")
@CrossOrigin(origins = "${config.cross.origin}")
public class ListController {

    @Autowired
    private ListService service;

    @GetMapping(value = "/list")
    public Iterable<ListDTO> list() {
        return this.service.list();
    }

    @PostMapping(value = "/list")
    public ListEntity save(@RequestBody ListEntity list){
        return this.service.save(list);
    }

    @DeleteMapping(value = "/list/{id}")
    public void delete(@PathVariable("id") String id){
        service.delete(id);
    }
}
