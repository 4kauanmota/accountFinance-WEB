package br.vianna.aula.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

@Entity
public class CreditAccount extends Account {
    @Column(nullable = false)
    private double cap;
    @Column(length = 3, nullable = false)
    private String securityCode;
    @Temporal(TemporalType.DATE)
    private Date validity;

    public CreditAccount() {
    }

    public CreditAccount(int id, String number, double balance, Date openingDate, User correntist, List<Circulation> circulations, List<AccountsPayable> accountsPayableList, List<AccountsReceivable> accountsReceivableList, double cap, String securityCode, Date validity) {
        super(id, number, balance, openingDate, correntist, circulations, accountsPayableList, accountsReceivableList);
        this.cap = cap;
        this.securityCode = securityCode;
        this.validity = validity;
    }

    public double getCap() {
        return cap;
    }

    public void setCap(double cap) {
        this.cap = cap;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public Date getValidity() {
        return validity;
    }

    public void setValidity(Date validity) {
        this.validity = validity;
    }
}
