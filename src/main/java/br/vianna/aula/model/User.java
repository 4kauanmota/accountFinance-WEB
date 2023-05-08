package br.vianna.aula.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length = 80)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(length = 30, nullable = false, unique = true)
    private String login;
    @Column(length = 40, nullable = false)
    private String password;
    @Temporal(TemporalType.TIMESTAMP)
    private Date acessDate;
    @Column(nullable = false)
    private double salary;
    @OneToMany
    @JoinColumn(name = "account")
    private List<Account> accounts = new ArrayList<>();

    public User() {
    }

    public User(int id, String name, String email, String login, String password, Date acessDate, double salary, List<Account> accounts) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.login = login;
        this.password = password;
        this.acessDate = acessDate;
        this.salary = salary;
        this.accounts = accounts;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getAcessDate() {
        return acessDate;
    }

    public void setAcessDate(Date acessDate) {
        this.acessDate = acessDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
