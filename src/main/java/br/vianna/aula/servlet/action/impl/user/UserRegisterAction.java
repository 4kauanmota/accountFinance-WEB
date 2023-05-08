package br.vianna.aula.servlet.action.impl.user;

import br.vianna.aula.model.User;
import br.vianna.aula.model.dao.UserDao;
import br.vianna.aula.servlet.action.IAction;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class UserRegisterAction implements IAction {
    @Override
    public void run(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/template.jsp?title=User&page=user/register&cssPackage=form");
        rd.forward(req, resp);
    }

    @Override
    public void define(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User u = new User(0, req.getParameter("name"),
                req.getParameter("email"),
                req.getParameter("login"),
                req.getParameter("password"),
                new Date(),
                Double.parseDouble(req.getParameter("salary")),
                new ArrayList<>()
        );

        if(u.getLogin().length() < 8){
            req.setAttribute("error", "The login must have at least 8 characteres long");
            RequestDispatcher rd = req.getRequestDispatcher("/template.jsp?title=User&page=user/register&cssPackage=form");
            rd.forward(req, resp);
        }
        else{
            new UserDao().save( u );
            resp.sendRedirect("/control?ac=user/list");
        }
    }
}
