package co.com.sofka.crud.Entities;

import co.com.sofka.crud.Entities.values.Label;
import co.com.sofka.crud.Entities.values.isCompleted;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Todo {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "Label",nullable = false)
    private Label label;

    @Column(name = "is_completed", nullable = false)
    private isCompleted completed;

    @Column(name = "group_list_id", nullable = false)
    private String groupListId;

    public String getGroupListId() {
        return groupListId;
    }

    public void setGroupListId(String groupListId) {
        this.groupListId = groupListId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public isCompleted isCompleted() {
        return completed;
    }

    public void setCompleted(isCompleted completed) {
        this.completed = completed;
    }
}
