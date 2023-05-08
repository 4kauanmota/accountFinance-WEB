package br.vianna.aula.servlet.action.impl;

import br.vianna.aula.model.User;
import br.vianna.aula.model.dao.UserDao;
import br.vianna.aula.servlet.action.IAction;
import br.vianna.aula.servlet.action.impl.user.UserLoginAction;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;

public class SignInAction implements IAction {
    @Override
    public void run(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        User u = new UserDao().login(login, password);

        if(u == null){
            req.setAttribute("error", "Login or password are incorrect");
            new UserLoginAction().run(req, resp);
        }
        else{
            u.setAcessDate(new Date());
            req.getSession().setAttribute("user", u);
            new HomeAction().run(req, resp);
        }
    }

    @Override
    public void define(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
