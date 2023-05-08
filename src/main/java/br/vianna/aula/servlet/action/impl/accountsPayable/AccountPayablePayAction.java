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
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class AccountPayablePayAction implements IAction {
    @Override
    public void run(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("user") == null){
            new UserLoginAction().run(req, resp);
        }

        List<AccountsPayable> accountsPayableList = new AccountsPayableDao().searchPaids();

        accountsPayableList.forEach(accountsPayable -> {
            if(accountsPayable.getExpirationDate().before(new Date())){
                accountsPayable.setIsExpirated(true);
            }
            else{
                accountsPayable.setIsExpirated(false);
            }
        });

        req.setAttribute("list", accountsPayableList);

        RequestDispatcher rd = req.getRequestDispatcher("/template.jsp?title=Accounts Payable&page=accountsPayable/pay&cssPackage=table&cssPackage2=form");
        rd.forward(req, resp);
    }

    @Override
    public void define(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        String provider = req.getParameter("provider");
        String description = req.getParameter("description");
        Double value = Double.parseDouble(req.getParameter("value"));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date expirationDate;
        String paymentMethod = req.getParameter("paymentMethod");
        AccountsPayable ap;

        try{
            expirationDate = dateFormat.parse(req.getParameter("expirationDate"));
        }
        catch (ParseException e){
            throw new RuntimeException(e);
        }

        ap = new AccountsPayable(
                id,
                provider,
                description,
                value,
                expirationDate,
                null,
                null,
                null
        );

        if(paymentMethod != "") {
            ap.setPaymentDate(new Date());
            ap.setPaymentMethod(paymentMethod);
        }

        new AccountsPayableDao().alter(ap);

        resp.sendRedirect("/control?ac=accountsPayable/list");
    }
}
