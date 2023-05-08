package br.vianna.aula.servlet.action.impl;

import br.vianna.aula.servlet.action.IAction;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class HelpAction implements IAction {
    @Override
    public void run(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("template.jsp?title=Help&page=help");
        rd.forward(req, resp);
    }

    @Override
    public void define(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
