package br.vianna.aula.model;

import javax.persistence.*;

@Entity
@Table(name = "expense")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = true, length = 30)
    private String name;
    @Column(nullable = true, length = 255)
    private String description;
    @Column(nullable = false)
    private double actualExpenses;
    @Column(nullable = false)
    private double cap;
    @ManyToOne
    @JoinColumn(name = "budget")
    private Budget budget;

    public Expense() {
    }

    public Expense(int id, String name, String description, double actualExpenses, double cap, Budget budget) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.actualExpenses = actualExpenses;
        this.cap = cap;
        this.budget = budget;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getActualExpenses() {
        return actualExpenses;
    }

    public void setActualExpenses(double actualExpenses) {
        this.actualExpenses = actualExpenses;
    }

    public double getCap() {
        return cap;
    }

    public void setCap(double cap) {
        this.cap = cap;
    }

    public Budget getBudget() {
        return budget;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }
}