package br.vianna.aula.servlet.action.impl.accountsReceivable;


import br.vianna.aula.model.AccountsReceivable;
import br.vianna.aula.model.dao.AccountsReceivableDao;
import br.vianna.aula.servlet.action.IAction;
import br.vianna.aula.servlet.action.impl.user.UserLoginAction;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AccountsReceivableListAction implements IAction {
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

        List<AccountsReceivable> accountsReceivableList;

        if(checkNull(parameters)) {
            accountsReceivableList = new AccountsReceivableDao().searchAll();
        }
        else{
            accountsReceivableList = new AccountsReceivableDao().searchByParameters(parameters);
        }

        req.setAttribute("list", accountsReceivableList);

        RequestDispatcher rd = req.getRequestDispatcher("/template.jsp?title=Accounts Receivable&page=accountsReceivable/list&cssPackage=table&cssPackage2=form");
        rd.forward(req, resp);
    }

    @Override
    public void define(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
