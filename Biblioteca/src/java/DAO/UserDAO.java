
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Usuario;

public class UsuarioDAO {

    static public boolean inserirUsuarioBanco(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nome, cpf, idade, endereco, telefone) VALUES (?,?,?,?,?)";

        Connection conexao = ConexaoBanco.CriaConexao();

        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setString(1, usuario.getNome());
            stm.setString(2, usuario.getCpf());
            stm.setInt(3, usuario.getIdade());
            stm.setString(4, usuario.getEndereco());
            stm.setString(5, usuario.getTelefone());
            stm.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("Não foi possivel executar tarefa ");
            return false;
        }

    }

    static public Usuario BuscarUsuarioPorId(int idUsuario) {
        String sql = "SELECT * FROM usuarios WHERE ID = ?";

        Connection conexao = ConexaoBanco.CriaConexao();

        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setInt(1, idUsuario);
            ResultSet retornoBanco = stm.executeQuery();
            if (retornoBanco.next()) {
                int id = retornoBanco.getInt("id");
                String nome = retornoBanco.getString("nome");
                String cpf = retornoBanco.getString("cpf");
                int idade = retornoBanco.getInt("idade");
                String endereco = retornoBanco.getString("endereco");
                String telefone = retornoBanco.getString("telefone");

                Usuario usuario = new Usuario(id,nome, cpf, idade, endereco, telefone);

                return usuario;
            } else {
                return null;
            }

        } catch (Exception e) {
            System.out.println("Não foi possivel executar tarefa");
            return null;
        }

    }

    static public ArrayList<Usuario> BuscarTodosUsuarios() {
        String sql = "SELECT * FROM usuarios";

        Connection conexao = ConexaoBanco.CriaConexao();

        ArrayList<Usuario> listaUsuario = new ArrayList<>();
        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            ResultSet retornoBanco = stm.executeQuery();

            while (retornoBanco.next()) {

                int id = retornoBanco.getInt("id");
                String nome = retornoBanco.getString("nome");
                String cpf = retornoBanco.getString("cpf");
                int idade = retornoBanco.getInt("idade");
                String endereco = retornoBanco.getString("endereco");
                String telefone = retornoBanco.getString("telefone");

                Usuario usuario = new Usuario(id, nome, cpf, idade, endereco, telefone);

                listaUsuario.add(usuario);

            }

            return listaUsuario;

        } catch (Exception e) {
            System.out.println("Não foi possivel executar tarefa");
            return null;
        }

    }

    static public String editarUsuarioBanco(int id, Usuario usuario) {
        String sql = "UPDATE usuarios SET nome = ?, cpf = ?, idade = ?, endereco = ?, telefone = ? WHERE id = ?";

        Connection conexao = ConexaoBanco.CriaConexao();

        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setString(1, usuario.getNome());
            stm.setString(2, usuario.getCpf());
            stm.setInt(3, usuario.getIdade());
            stm.setString(4, usuario.getEndereco());
            stm.setString(5, usuario.getTelefone());
            stm.setInt(6, id);
            stm.executeUpdate();
            return "Usuario atualizado com sucesso!";

        } catch (Exception e) {
            System.out.println("Não foi possivel executar tarefa");
            return "";
        }

    }

    public static String DeletarUsuarioPorId(int id) {
        String sql = "delete FROM usuarios WHERE ID = ?";
        Connection conexao = ConexaoBanco.CriaConexao();

        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate();
            
            return "Usuario deletado com sucesso!";

        } catch (Exception e) {
            System.out.println("Não foi possivel executar tarefa");
            return "";
        }

    }



}
