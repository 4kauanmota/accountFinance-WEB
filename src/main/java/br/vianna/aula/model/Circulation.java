package br.vianna.aula.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "circulation")
public class Circulation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(length = 255)
    private String description;
    @Column(nullable = false)
    private double value;
    @OneToOne
    @JoinColumn(name = "category")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "account")
    private Account account;

    public Circulation() {
    }

    public Circulation(int id, Date date, String description, double value, Category category, Account account) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.value = value;
        this.category = category;
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category categorys) {
        this.category = categorys;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account idAccount) {
        this.account = idAccount;
    }
}
