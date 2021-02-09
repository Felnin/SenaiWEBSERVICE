package controller;

import java.util.ArrayList;
import java.util.List;
import model.Emprestimo;
import model.Livro;

public class EmprestimoController {

    private static List<Emprestimo> listaEmprestimos = new ArrayList();

    private int id;
    private int idEmprestimo;
    private int idLivro;
    private int idUsuario;

    public static List<Emprestimo> getList() {
        return listaEmprestimos;
    }

    public static void addEmprestimo(Emprestimo obj) {
        listaEmprestimos.add(obj);
    }
}
