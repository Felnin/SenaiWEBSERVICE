
package controller;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;

public class UsuarioController {
    private static List <Usuario> listaUsuarios = new ArrayList();

    public static List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }
    
    public static void addUsuario(Usuario obj){
        listaUsuarios.add(obj);
    }
    
    public static String getTodosOsUsuarios(){
          Gson gson = new Gson();
          String resultado = gson.toJson(listaUsuarios);
          return resultado;
    }
    
    public static String getListUsuarioEspecifico(int id){
         Gson gson = new Gson();
         try {
            Usuario usuario = listaUsuarios.get(id);
            String resultado = gson.toJson(usuario);
            return resultado;
        } catch (Exception e) {
        }
         return "Usuario não encontrado";
    }
    
        public static boolean delete(int id){
         boolean Achou = false;
         
         for(int i =0; i < listaUsuarios.size(); i++){
             if(listaUsuarios.get(i).getId() == id){
                listaUsuarios.remove(i);
                Achou = true;
             }
         }
         
         return Achou;    
     }
    
    public static boolean update(int id, Usuario obj){
         boolean Achou = false;
         
        for (Usuario listaUsuario : listaUsuarios) {
            if (listaUsuario.getId() == id) {
                listaUsuario.setNome(obj.getNome());
                listaUsuario.setCpf(obj.getCpf());
                listaUsuario.setIdade(obj.getIdade());
                Achou = true;
            }
        }
         
         return Achou;    
     }
    
}
