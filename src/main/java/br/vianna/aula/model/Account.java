package br.vianna.aula.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(length = 80, nullable = false)
    private String number;
    private double balance;
    @Temporal(TemporalType.TIMESTAMP)
    private Date openingDate;
    @ManyToOne
    @JoinColumn(name = "user")
    private User correntist;
    @OneToMany
    @JoinColumn(name = "circulation")
    private List<Circulation> circulations = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "accountsPayable")
    private List<AccountsPayable> accountsPayableList = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "accountsReceivable")
    private List<AccountsReceivable> accountsReceivableList = new ArrayList<>();

    public Account() {
    }

    public Account(int id, String number, double balance, Date openingDate, User correntist, List<Circulation> circulations, List<AccountsPayable> accountsPayableList, List<AccountsReceivable> accountsReceivableList) {
        this.id = id;
        this.number = number;
        this.balance = balance;
        this.openingDate = openingDate;
        this.correntist = correntist;
        this.circulations = circulations;
        this.accountsPayableList = accountsPayableList;
        this.accountsReceivableList = accountsReceivableList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    public User getCorrentist() {
        return correntist;
    }

    public void setCorrentist(User correntist) {
        this.correntist = correntist;
    }

    public List<Circulation> getCirculations() {
        return circulations;
    }

    public void setCirculations(List<Circulation> circulations) {
        this.circulations = circulations;
    }

    public List<AccountsPayable> getAccountsPayableList() {
        return accountsPayableList;
    }

    public void setAccountsPayableList(List<AccountsPayable> accountsPayableList) {
        this.accountsPayableList = accountsPayableList;
    }

    public List<AccountsReceivable> getAccountsReceivableList() {
        return accountsReceivableList;
    }

    public void setAccountsReceivableList(List<AccountsReceivable> accountsReceivableList) {
        this.accountsReceivableList = accountsReceivableList;
    }
}
