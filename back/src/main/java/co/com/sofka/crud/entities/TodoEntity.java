package co.com.sofka.crud.entities;

import javax.persistence.*;

@Entity
@Table(name = "Todo")
public class TodoEntity {
    @Id
    @Column(name = "todo_id", nullable = false, unique = true)
    private String id;

    @Column(name = "Label",nullable = false)
    private String label;

    @Column(name = "is_completed", nullable = false)
    private Boolean isCompleted;

    @Column(name = "list_id", nullable = false)
    private String listId;

    public TodoEntity() {
    }

    public String getListId() {
        return listId;
    }

    public void setListId(String listId) {
        this.listId = listId;
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

    public Boolean getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(Boolean completed) {
        this.isCompleted = completed;
    }
}
