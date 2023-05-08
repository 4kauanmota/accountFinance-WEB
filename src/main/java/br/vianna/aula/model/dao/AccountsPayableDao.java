package br.vianna.aula.model.dao;

import br.vianna.aula.model.AccountsPayable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class AccountsPayableDao implements GenericsDao<AccountsPayable, Integer>{
    private EntityManager em;

    public AccountsPayableDao() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("database");
        em = emf.createEntityManager();
    }

    @Override
    public List<AccountsPayable> searchAll() {
        return em.createQuery("SELECT ap FROM AccountsPayable ap").getResultList();
    }

    @Override
    public List<AccountsPayable> searchByParameters(ArrayList<String> parameters) {
        List<AccountsPayable> result;

        Query query = em.createQuery("SELECT ap FROM AccountsPayable ap WHERE ap.provider LIKE :provider AND ap.description LIKE :description");
        query.setParameter("provider", "%" + parameters.get(0) + "%");
        query.setParameter("description", "%" + parameters.get(1) + "%");

        result = query.getResultList();

        return result;
    }

    @Override
    public void alter(AccountsPayable ap) {
        em.getTransaction().begin();

        em.createQuery("UPDATE AccountsPayable ap SET ap.description = :description, ap.expirationDate = :expirationDate, ap.paymentDate = :paymentDate, ap.paymentMethod = :paymentMethod, ap.provider = :provider, ap.value = :value WHERE ap.id = :id")
                .setParameter("description", ap.getDescription())
                .setParameter("expirationDate", ap.getExpirationDate())
                .setParameter("paymentDate", ap.getPaymentDate())
                .setParameter("paymentMethod", ap.getPaymentMethod())
                .setParameter("provider", ap.getProvider())
                .setParameter("value", ap.getValue())
                .setParameter("id", ap.getId())
                .executeUpdate();

        em.getTransaction().commit();

        em.close();
    }

    @Override
    public void save(AccountsPayable ap) {
        em.getTransaction().begin();
        em.merge(ap);
        em.getTransaction().commit();
    }

    public List<AccountsPayable> searchPaids() {
        return em.createQuery("SELECT ap FROM AccountsPayable ap WHERE ap.paymentMethod = null OR ap.paymentMethod = ''").getResultList();
    }
}
