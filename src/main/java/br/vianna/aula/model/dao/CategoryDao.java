package br.vianna.aula.model.dao;

import br.vianna.aula.model.Category;
import br.vianna.aula.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao implements GenericsDao<Category, Integer>{
    private EntityManager em;

    public CategoryDao() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("database");
        em = emf.createEntityManager();
    }

    @Override
    public List<Category> searchAll() {
        return em.createQuery("SELECT cty FROM Category cty").getResultList();
    }

    @Override
    public List<Category> searchByParameters(ArrayList<String> parameters) {
        List<Category> result;

        Query query = em.createQuery("SELECT cty FROM Category cty WHERE cty.name LIKE :name");
        query.setParameter("name", "%" + parameters.get(0) + "%");
        result = query.getResultList();

        return result;
    }

    public Category searchByName(String name) {
        Query query = em.createQuery("SELECT cty FROM Category cty WHERE cty.name = :name");
        query.setParameter("name", name);

        try {
            List<Category> result = query.getResultList();
            Category cty = result.get(0);
            return cty;
        }
        catch (Exception error){
            return null;
        }
    }

    @Override
    public void save(Category cty) {
        em.getTransaction().begin();
        em.merge(cty);
        em.getTransaction().commit();
    }

    @Override
    public void alter(Category cty) {

    }
}
