package br.vianna.aula.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

@Entity
public class BankAccount extends Account {
    @Column(nullable = false)
    private boolean special;
    @Column(nullable = false)
    private double cap;

    public BankAccount() {
    }

    public BankAccount(int id, String number, double balance, Date openingDate, User correntist, List<Circulation> circulations, List<AccountsPayable> accountsPayableList, List<AccountsReceivable> accountsReceivableList, boolean special, double cap) {
        super(id, number, balance, openingDate, correntist, circulations, accountsPayableList, accountsReceivableList);
        this.special = special;
        this.cap = cap;
    }

    public boolean isSpecial() {
        return special;
    }

    public void setSpecial(boolean special) {
        this.special = special;
    }

    public double getCap() {
        return cap;
    }

    public void setCap(double cap) {
        this.cap = cap;
    }
}
