package br.vianna.aula.servlet.action.impl.user;

import br.vianna.aula.servlet.action.IAction;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class UserLoginAction implements IAction {
    @Override
    public void run(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/template.jsp?title=User&page=user/login&cssPackage=form");
        rd.forward(req, resp);
    }

    @Override
    public void define(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
