package br.vianna.aula.servlet.action.impl.category;

import br.vianna.aula.model.Category;
import br.vianna.aula.model.dao.CategoryDao;
import br.vianna.aula.servlet.action.IAction;
import br.vianna.aula.servlet.action.impl.user.UserLoginAction;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CategoryRegisterAction implements IAction {
    @Override
    public void run(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") == null){
            new UserLoginAction().run(req, resp);
        }

        RequestDispatcher rd = req.getRequestDispatcher("/template.jsp?title=Category&page=category/register&cssPackage=form");
        rd.forward(req, resp);
    }

    @Override
    public void define(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");

        Category cty = new Category(
                0,
                name,
                null
        );

        new CategoryDao().save(cty);

        resp.sendRedirect("/control?ac=category/list");
    }
}
