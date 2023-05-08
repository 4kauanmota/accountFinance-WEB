package br.vianna.aula.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "accountsPayable")
public class AccountsPayable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String provider;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private double value;

    @Temporal(TemporalType.DATE)
    private Date expirationDate;

    @Temporal(TemporalType.DATE)
    private Date paymentDate;

    @Column()
    private String paymentMethod;

    private boolean isExpirated;

    @ManyToOne
    @JoinColumn(name = "account")
    private Account account = new Account();

    public AccountsPayable() {
    }

    public AccountsPayable(int id, String provider, String description, double value, Date expirationDate, Date paymentDate, String paymentMethod, Account account) {
        this.id = id;
        this.provider = provider;
        this.description = description;
        this.value = value;
        this.expirationDate = expirationDate;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
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

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public boolean getIsExpirated() {
        return isExpirated;
    }

    public void setIsExpirated(boolean expirated) {
        isExpirated = expirated;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
