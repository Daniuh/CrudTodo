package co.com.sofka.crud.dtos;

import java.util.List;

public class ListDTO {
    private String id;
    private String label;
    private List<TodoDTO> todoDTO;

    public ListDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<TodoDTO> getTodoDTO() {
        return todoDTO;
    }

    public void setTodoDTO(List<TodoDTO> todoDTO) {
        this.todoDTO = todoDTO;
    }
}