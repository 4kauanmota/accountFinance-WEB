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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountsPayableRegisterAction implements IAction {
    @Override
    public void run(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") == null){
            new UserLoginAction().run(req, resp);
        }

        RequestDispatcher rd = req.getRequestDispatcher("/template.jsp?title=Accounts Payable&page=accountsPayable/register&cssPackage=form");
        rd.forward(req, resp);
    }

    @Override
    public void define(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String provider = req.getParameter("provider");
        String description = req.getParameter("description");
        Double value = Double.parseDouble(req.getParameter("value"));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date expirationDate;

        try {
            expirationDate = dateFormat.parse(req.getParameter("expirationDate"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        AccountsPayable ap = new AccountsPayable(
                0,
                provider,
                description,
                value,
                expirationDate,
                null,
                null,
                null
        );

        Pattern specialCharacters = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
        Matcher hasSpecialCharacter = specialCharacters.matcher(ap.getDescription());

        if(hasSpecialCharacter.find()){
            req.setAttribute("error", "The description cannot contain special characters");
            new AccountsPayableRegisterAction().run(req,resp);
        }
        else if(ap.getValue() < 0) {
            req.setAttribute("error", "The account value cannot be negative");
            new AccountsPayableRegisterAction().run(req,resp);
        }
        else if(expirationDate.before(new Date())) {
            req.setAttribute("error", "The expiration date cant be before the actual date");
            new AccountsPayableRegisterAction().run(req,resp);
        }
        else{
            new AccountsPayableDao().save( ap );
            resp.sendRedirect("/control?ac=accountsPayable/list");
        }
    }
}
