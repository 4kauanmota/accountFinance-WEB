package br.vianna.aula.model.dao;

import br.vianna.aula.model.AccountsPayable;

import java.util.ArrayList;
import java.util.List;

public interface GenericsDao <C, K>{
    public List<C> searchAll();
    public List<C> searchByParameters(ArrayList<String> parameters);
    void save(C obj);
    void alter(C obj);
}
