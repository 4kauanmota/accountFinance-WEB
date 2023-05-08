package br.vianna.aula.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "budget")
public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToOne
    @JoinColumn(name = "conta")
    private Account account;
    @OneToMany
    @JoinColumn(name = "expense")
    private List<Expense> expense = new ArrayList<>();

    public Budget() {
    }

    public Budget(int id, Account account, List<Expense> expense) {
        this.id = id;
        this.account = account;
        this.expense = expense;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Expense> getExpense() {
        return expense;
    }

    public void setExpense(List<Expense> expense) {
        this.expense = expense;
    }
}