package br.vianna.aula.model.dao;

import br.vianna.aula.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements GenericsDao<User, Integer> {
    private EntityManager em;
    public UserDao(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("database");
        em = emf.createEntityManager();
    }
    @Override
    public List<User> searchAll() {
        return em.createQuery("select u from User u").getResultList();
    }

    @Override
    public List<User> searchByParameters(ArrayList<String> parameters) {
        List<User> result;

        Query query = em.createQuery("SELECT u FROM User u WHERE u.name LIKE :name AND u.email LIKE :email AND u.login LIKE :login");
        query.setParameter("name", "%" + parameters.get(0) + "%");
        query.setParameter("email", "%" + parameters.get(1) + "%");
        query.setParameter("login", "%" + parameters.get(2) + "%");

        result = query.getResultList();

        return result;
    }

    @Override
    public void save(User u) {
        em.getTransaction().begin();
        em.merge(u);
        em.getTransaction().commit();
    }

    @Override
    public void alter(User obj) {

    }

    public User login(String login, String password){
        Query query = em.createQuery("SELECT u FROM User u " +
                "WHERE u.login = :login AND u.password = :password");
        query.setParameter("login", login);
        query.setParameter("password", password);

        try {
            List<User> result = query.getResultList();
            User u = result.get(0);
            return u;
        }
        catch (Exception error){
            return null;
        }
    }
}
