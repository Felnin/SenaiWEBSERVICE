
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Emprestimo;

public class EmprestimoDAO {

    public static boolean inserirEmprestimoBanco(Emprestimo emprestimo) {
        String sql = "INSERT INTO emprestimos ((id, idusuario, datainicio, datafim, id, ativo) VALUES (?,?,?,?,?,?)";

        Connection conexao = ConexaoBanco.CriaConexao();

        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setInt(1, emprestimo.getId());
            stm.setInt(6, emprestimo.getId());
            stm.setString(2, emprestimo.getDataInicio());
            stm.setString(3, emprestimo.getDataFim());
            stm.setDouble(4, emprestimo.getMulta());
            stm.setBoolean(5, emprestimo.isAtivo());
            stm.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("Não foi possivel executar tarefa ");
            return false;
        }
    }

    public static Emprestimo BuscarEmprestimoLivroId(int idEmprestimo) {
        String sql = "SELECT * FROM emprestimos WHERE ID = ?";

        Connection conexao = ConexaoBanco.CriaConexao();

        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setInt(1, idEmprestimo);
            ResultSet retornoBanco = stm.executeQuery();
            if (retornoBanco.next()) {
                int id = retornoBanco.getInt("id");
                int idusuario = retornoBanco.getInt("idUsuario");             
                String dataInicio = retornoBanco.getString("dataInicio");
                String dataFim = retornoBanco.getString("dataFim");
                int multa = retornoBanco.getInt("multa");
                boolean ativo = retornoBanco.getBoolean("ativo");
                
                Emprestimo emprestimo = new Emprestimo(id, idusuario, dataInicio, dataFim, id, ativo);
                return emprestimo;
            } else {
                return null;
            }

        } catch (Exception e) {
            System.out.println("Não foi possivel executar tarefa");
            return null;
        }
    }

    public static String EditarEmprestimoLivroId(int id, Emprestimo emprestimo) {
        String sql = "UPDATE emprestimos SET ativo = ? WHERE id =?";

        Connection conexao = ConexaoBanco.CriaConexao();

        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setBoolean(1, emprestimo.isAtivo());
            stm.setInt(2, id);
        
            stm.executeUpdate();
         
            return "Emprestimo atualizado com sucesso!";

        } catch (Exception e) {
            System.out.println("Não foi possivel executar tarefa");
            return "erro";
        }
    }
    

}
