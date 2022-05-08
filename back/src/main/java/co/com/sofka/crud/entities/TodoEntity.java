package co.com.sofka.crud.entities;

import javax.persistence.*;

@Entity
@Table(name = "Todo")
public class TodoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_id", nullable = false)
    private Long id;

    @Column(name = "Label",nullable = false)
    private String label;

    @Column(name = "is_completed", nullable = false)
    private Boolean isCompleted;

    @Column(name = "list_id", nullable = false)
    private Integer ListId;

    public Integer getListId() {
        return ListId;
    }

    public void setListId(Integer groupListId) {
        this.ListId = groupListId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        isCompleted = completed;
    }
}
