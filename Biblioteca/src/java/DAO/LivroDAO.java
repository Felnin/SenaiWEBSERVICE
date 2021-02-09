
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import models.Livro;
import models.User;

public class LivroDAO {

    public static boolean inserirLivroBanco(Livro livro) {
        String sql = "INSERT INTO livros (nome, quantidade, areaLivro, resumo, anoPublicacao, edicao) VALUES (?,?,?,?,?,?)";

        Connection conexao = ConexaoBanco.CriaConexao();

        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setString(1, livro.getNome());
            stm.setInt(2, livro.getQuantidade());
            stm.setInt(3, livro.getAreaLivro());
            stm.setString(4, livro.getResumo());
            stm.setInt(5, livro.getAnoPublicacao());
            stm.setInt(6, livro.getEdicao());
            stm.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("Não foi possivel executar tarefa ");
            return false;
        }
    }

    public static Object BuscarTodosLivros() {
        String sql = "SELECT * FROM livros";

        Connection conexao = ConexaoBanco.CriaConexao();

        ArrayList<Livro> listaLivros = new ArrayList<>();
        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            ResultSet retornoBanco = stm.executeQuery();

            while (retornoBanco.next()) {

                int id = retornoBanco.getInt("id");
                String nome = retornoBanco.getString("nome");
                int quantidade = retornoBanco.getInt("quantidade");
                int areaLivro = retornoBanco.getInt("areaLivro");
                String resumo = retornoBanco.getString("resumo");
                int anoPublicacao = retornoBanco.getInt("anoPublicacao");
                int edicao = retornoBanco.getInt("edicao");

                Livro livro = new Livro(quantidade, nome, areaLivro, resumo, anoPublicacao, edicao);

                listaLivros.add(livro);

            }

            return listaLivros;

        } catch (Exception e) {
            System.out.println("Não foi possivel executar tarefa");
            return null;
        }
    }

    public static Livro BuscarLivroPorId(int idLivro) {
        String sql = "SELECT * FROM livros WHERE ID = ?";

        Connection conexao = ConexaoBanco.CriaConexao();

        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setInt(1, idLivro);
            ResultSet retornoBanco = stm.executeQuery();
            if (retornoBanco.next()) {
                int id = retornoBanco.getInt("id");
                String nome = retornoBanco.getString("nome");
                int quantidade = retornoBanco.getInt("quantidade");
                int areaLivro = retornoBanco.getInt("areaLivro");
                String resumo = retornoBanco.getString("resumo");
                int anoPublicacao = retornoBanco.getInt("anoPublicacao");
                int edicao = retornoBanco.getInt("edicao");
                Livro livro = new Livro(quantidade, nome, areaLivro, resumo, anoPublicacao, edicao);

                return livro;
            } else {
                return null;
            }

        } catch (Exception e) {
            System.out.println("Não foi possivel executar tarefa");
            return null;
        }

    }

    public static String DeletarLivroPorId(int id) {
        String sql = "delete FROM livros WHERE ID = ?";
        Connection conexao = ConexaoBanco.CriaConexao();

        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate();

            return "Livro deletado com sucesso!";

        } catch (Exception e) {
            System.out.println("Não foi possivel executar tarefa");
            return "Não foi possivel executar tarefa";
        }
    }

    public static String editarLivroBanco(int id, Livro livro) {
        String sql = "UPDATE users SET nome = ?, quantidade = ?, arealivro = ?, resumo = ?, anopublicacao = ?, edicao = ? WHERE id = ?";

        Connection conexao = ConexaoBanco.CriaConexao();

        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setString(1, livro.getNome());
            stm.setInt(2, livro.getQuantidade());
            stm.setInt(3, livro.getAreaLivro());
            stm.setString(4, livro.getResumo());
            stm.setInt(5, livro.getAnoPublicacao());
            stm.setInt(6, livro.getEdicao());
            stm.setInt(7, id);
            stm.executeUpdate();
         
            return "Livro atualizado com sucesso!";

        } catch (Exception e) {
            System.out.println("Não foi possivel executar tarefa");
            return "";
        }
    }

}
