package co.com.sofka.crud.Entities;

import co.com.sofka.crud.Entities.values.Label;

import javax.persistence.*;

@Entity
@Table(name = "Todos")
public class Todos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "Label", nullable = false)
    private Label label;

    public Todos() {
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
}
