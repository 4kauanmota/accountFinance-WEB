package br.vianna.aula.servlet.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface IAction {
    public void run(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

    public void define(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
