package br.vianna.aula.model.dao;

import br.vianna.aula.model.Circulation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class CirculationDao implements GenericsDao<Circulation, Integer>{
    private EntityManager em;

    public CirculationDao() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("database");
        em = emf.createEntityManager();
    }

    @Override
    public List<Circulation> searchAll() {
        return em.createQuery("SELECT crl FROM Circulation crl").getResultList();
    }

    @Override
    public List<Circulation> searchByParameters(ArrayList<String> parameters) {
        List<Circulation> result;

        Query query = em.createQuery("SELECT crl FROM Circulation crl WHERE crl.description LIKE :description");
        query.setParameter("description", "%" + parameters.get(0) + "%");
        result = query.getResultList();

        return result;
    }

    @Override
    public void save(Circulation crl) {
        em.getTransaction().begin();
        em.merge(crl);
        em.getTransaction().commit();
    }

    @Override
    public void alter(Circulation cty) {

    }
}
