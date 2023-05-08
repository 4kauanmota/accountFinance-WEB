package br.vianna.aula.model.dao;

import br.vianna.aula.model.AccountsReceivable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class AccountsReceivableDao implements GenericsDao<AccountsReceivable, Integer>{
    private EntityManager em;

    public AccountsReceivableDao() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("database");
        em = emf.createEntityManager();
    }

    @Override
    public List<AccountsReceivable> searchAll() {
        return em.createQuery("SELECT ar FROM AccountsReceivable ar").getResultList();
    }

    @Override
    public List<AccountsReceivable> searchByParameters(ArrayList<String> parameters) {
        List<AccountsReceivable> result;

        Query query = em.createQuery("SELECT ar FROM AccountsReceivable ar WHERE ar.provider LIKE :provider AND ar.description LIKE :description");
        query.setParameter("provider", "%" + parameters.get(0) + "%");
        query.setParameter("description", "%" + parameters.get(1) + "%");
        result = query.getResultList();

        return result;
    }

    @Override
    public void alter(AccountsReceivable ar) {
        em.getTransaction().begin();

        em.createQuery("UPDATE AccountsRacivable ar SET ar.description = :description, ar.expirationDate = :expirationDate, ar.paymentDate = :paymentDate, ar.paymentMethod = :paymentMethod, ar.provider = :provider, ar.value = :value WHERE ar.id = :id")
                .setParameter("description", ar.getDescription())
                .setParameter("expirationDate", ar.getExpirationDate())
                .setParameter("paymentDate", ar.getPaymentDate())
                .setParameter("paymentMethod", ar.getPaymentMethod())
                .setParameter("provider", ar.getProvider())
                .setParameter("value", ar.getValue())
                .setParameter("id", ar.getId())
                .executeUpdate();

        em.getTransaction().commit();

        em.close();
    }

    @Override
    public void save(AccountsReceivable ar) {
        em.getTransaction().begin();
        em.merge(ar);
        em.getTransaction().commit();
    }

    public List<AccountsReceivable> searchPaids() {
        return em.createQuery("SELECT ar FROM AccountsReceivable ar WHERE ar.paymentMethod = null OR ar.paymentMethod = ''").getResultList();
    }
}
