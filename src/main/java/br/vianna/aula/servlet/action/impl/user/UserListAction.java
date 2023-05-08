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
import java.util.List;

public class UserListAction implements IAction {
    public boolean checkNull(ArrayList<String> array){
        for(String s : array){
            if(s != null){
                return false;
            }
        }

        return true;
    }

    @Override
    public void run(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") == null){
            new UserLoginAction().run(req, resp);
        }

        ArrayList<String> parameters = new ArrayList<>();
        parameters.add( req.getParameter("name") );
        parameters.add( req.getParameter("email") );
        parameters.add( req.getParameter("login") );

        List<User> userList;
        if(checkNull(parameters)) {
            userList = new UserDao().searchAll();
        }
        else{
            userList = new UserDao().searchByParameters(parameters);
        }

        req.setAttribute("list", userList);

        RequestDispatcher rd = req.getRequestDispatcher("/template.jsp?title=User&page=user/list&cssPackage=table&cssPackage2=form");
        rd.forward(req, resp);
    }

    @Override
    public void define(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
