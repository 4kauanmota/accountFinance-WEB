package br.vianna.aula.model;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length = 255)
    private String name;
    @ManyToOne
    @JoinColumn(name = "circulation")
    private Circulation circulation;

    public Category() {
    }

    public Category(int id, String name, Circulation circulation) {
        this.id = id;
        this.name = name;
        this.circulation = circulation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Circulation getCirculation() {
        return circulation;
    }

    public void setCirculation(Circulation circulation) {
        this.circulation = circulation;
    }
}
