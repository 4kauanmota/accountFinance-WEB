package br.vianna.aula.servlet.action.impl.circulation;

import br.vianna.aula.model.Category;
import br.vianna.aula.model.Circulation;
import br.vianna.aula.model.dao.CategoryDao;
import br.vianna.aula.model.dao.CirculationDao;
import br.vianna.aula.servlet.action.IAction;
import br.vianna.aula.servlet.action.impl.user.UserLoginAction;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class CirculationRegisterAction implements IAction {
    @Override
    public void run(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") == null){
            new UserLoginAction().run(req, resp);
        }
        List<Category> categoryList = new CategoryDao().searchAll();

        req.setAttribute("list", categoryList);

        RequestDispatcher rd = req.getRequestDispatcher("/template.jsp?title=Circulation&page=circulation/register&cssPackage=table&cssPackage2=form");
        rd.forward(req, resp);
    }

    @Override
    public void define(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String description = req.getParameter("description");
        Double value = Double.parseDouble(req.getParameter("value"));
        Category category = new CategoryDao().searchByName(req.getParameter("category"));

        Circulation crl = new Circulation(
                0,
                new Date(),
                description,
                value,
                category,
                null
        );

        new CirculationDao().save(crl);

        resp.sendRedirect("/control?ac=circulation/list");
    }
}
