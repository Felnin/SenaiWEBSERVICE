package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoBanco {

    private static final String driver = "org.postgresql.Driver";

    private static final String usuario = "postgres";

    private static final String senha = "123123";

    private static final String URL = "jdbc:postgresql://localhost:8080/";

    private static Connection conexao = null;

    public static Connection CriaConexao() {
        if (conexao == null) {
            try {
                 Class.forName(driver);
                 conexao = DriverManager.getConnection(URL , usuario, senha);
                 System.out.println("Conexão feita com sucesso");
            } catch (Exception e) {
                System.out.println("Problema ao conectar no Banco de dados!"+ e.getMessage());
            }
            
        }
        return conexao;
    }

}
