package controller;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import model.Livro;

public class LivroController {

    private static List<Livro> listaLivros = new ArrayList();

    public static List<Livro> getList() {
        return listaLivros;
    }

    public static void addLivro(Livro obj) {
        listaLivros.add(obj);
    }

    public static String getTodosOsLivros() {
        Gson gson = new Gson();
        String resultado = gson.toJson(listaLivros);
        return resultado;
    }

    public static String getListLivroEspecifico(int id) {
        Gson gson = new Gson();
        try {
            Livro livro = listaLivros.get(id);
            String resultado = gson.toJson(livro);
            return resultado;
        } catch (Exception e) {
        }
        return "Livro não encontrado";
    }

    public static boolean delete(int id) {
        boolean Achou = false;

        for (int i = 0; i < listaLivros.size(); i++) {
            if (listaLivros.get(i).getId() == id) {
                listaLivros.remove(i);
                Achou = true;
            }
        }

        return Achou;
    }

    public static boolean update(int id, Livro obj) {
        boolean Achou = false;

        for (int i = 0; i < listaLivros.size(); i++) {
            if (listaLivros.get(i).getId() == id) {
                listaLivros.get(i).setNome(obj.getNome());
                listaLivros.get(i).setQuantidade(obj.getQuantidade());
                listaLivros.get(i).setArea(obj.getArea());
                Achou = true;
            }
        }

        return Achou;
    }
}
