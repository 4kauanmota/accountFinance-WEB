package br.vianna.aula.servlet.action.impl.accountsPayable;

import br.vianna.aula.model.AccountsPayable;
import br.vianna.aula.model.dao.AccountsPayableDao;
import br.vianna.aula.servlet.action.IAction;
import br.vianna.aula.servlet.action.impl.user.UserLoginAction;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AccountsPayableListAction implements IAction {
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
        parameters.add( req.getParameter("provider") );
        parameters.add( req.getParameter("description") );

        List<AccountsPayable> accountsPayableList;

        if(checkNull(parameters)) {
            accountsPayableList = new AccountsPayableDao().searchAll();
        }
        else{
            accountsPayableList = new AccountsPayableDao().searchByParameters(parameters);
        }

        req.setAttribute("list", accountsPayableList);

        RequestDispatcher rd = req.getRequestDispatcher("/template.jsp?title=Accounts Payable&page=accountsPayable/list&cssPackage=table&cssPackage2=form");
        rd.forward(req, resp);
    }

    @Override
    public void define(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
