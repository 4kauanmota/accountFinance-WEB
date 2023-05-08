package br.vianna.aula.servlet;

import br.vianna.aula.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;

@WebServlet(urlPatterns = {"/database"})
public class DatabaseServlet extends HttpServlet {
    public DatabaseServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("database");
        EntityManager em = emf.createEntityManager();

        User u = new User(1, "Kauan", "4kauanmota@gmail.com", "4kauanmota", "123", null, 1000, null);

        em.getTransaction().begin();
        em.merge(u);
        em.getTransaction().commit();

        resp.getWriter().write("Conected! " + em.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
