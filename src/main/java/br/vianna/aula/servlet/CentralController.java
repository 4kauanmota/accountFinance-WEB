package br.vianna.aula.servlet;

import br.vianna.aula.servlet.action.IAction;
import br.vianna.aula.servlet.action.impl.*;
import br.vianna.aula.servlet.action.impl.accountsPayable.*;
import br.vianna.aula.servlet.action.impl.accountsReceivable.AccountsReceivableListAction;
import br.vianna.aula.servlet.action.impl.accountsReceivable.AccountsReceivableRegisterAction;
import br.vianna.aula.servlet.action.impl.category.CategoryListAction;
import br.vianna.aula.servlet.action.impl.category.CategoryRegisterAction;
import br.vianna.aula.servlet.action.impl.circulation.CirculationListAction;
import br.vianna.aula.servlet.action.impl.circulation.CirculationRegisterAction;
import br.vianna.aula.servlet.action.impl.user.UserListAction;
import br.vianna.aula.servlet.action.impl.user.UserLoginAction;
import br.vianna.aula.servlet.action.impl.user.UserRegisterAction;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = { "/control" })
public class CentralController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        get(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        post(req, resp);
    }

    static Map<String, IAction> commands = new HashMap<>();
    static {
        commands.put(null, new HomeAction());
        commands.put("help", new HelpAction());
        commands.put("menu", new MenuAction());

        commands.put("user/register", new UserRegisterAction());
        commands.put("user/list", new UserListAction());
        commands.put("user/login", new UserLoginAction());

        commands.put("accountsPayable/register", new AccountsPayableRegisterAction());
        commands.put("accountsPayable/list", new AccountsPayableListAction());
        commands.put("accountsPayable/pay", new AccountPayablePayAction());

        commands.put("accountsReceivable/register", new AccountsReceivableRegisterAction());
        commands.put("accountsReceivable/list", new AccountsReceivableListAction());

        commands.put("category/register", new CategoryRegisterAction());
        commands.put("category/list", new CategoryListAction());

        commands.put("circulation/register", new CirculationRegisterAction());
        commands.put("circulation/list", new CirculationListAction());

        commands.put("signIn", new SignInAction());
        commands.put("signOut", new SignOutAction());
    }

    private void get(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String ac = req.getParameter("ac");
            commands.get(ac).run(req, resp);
        }
        catch (Exception e){
            req.setAttribute("erro", "Unrecognized error");
            RequestDispatcher rd = req.getRequestDispatcher("template.jsp?title=Erro");
            rd.forward(req, resp);
        }
    }

    private void post(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String ac = req.getParameter("ac");
            commands.get(ac).define(req, resp);
        }
        catch (Exception e){
            req.setAttribute("erro", "Unrecognized error");
            RequestDispatcher rd = req.getRequestDispatcher("template.jsp?title=Erro");
            rd.forward(req, resp);
        }
    }
}
