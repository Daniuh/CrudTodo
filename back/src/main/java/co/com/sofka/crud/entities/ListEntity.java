package co.com.sofka.crud.entities;

import javax.persistence.*;

@Entity
@Table(name = "List")
public class ListEntity {
    @Id
    @Column(name = "list_id", nullable = false, unique = true)
    private String id;

    @Column(name = "Label", nullable = false)
    private String label;


    public ListEntity() {
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
}
