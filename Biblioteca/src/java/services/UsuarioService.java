
package services;

import controller.LivroController;
import controller.UsuarioController;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Livro;
import model.Usuario;

@Path("/usuario")
public class UsuarioService {
    
    @GET
    @Path("/lista")
    @Produces(MediaType.APPLICATION_JSON)
    public String getListaUsuarios() {
        return UsuarioController.getTodosOsUsuarios();
    }
    
    @GET
    @Path("/lista/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getListaLivroEspecifico(@PathParam("id") int id) {
        String respostaDoController = UsuarioController.getListUsuarioEspecifico(id);
        return respostaDoController;
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") int id) {
        if (UsuarioController.delete(id)) {
            return Response.ok().build();
        } else {
            return Response.serverError().build();
        }

    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/update/{id}")
    public Response updateJson(@PathParam("id") int id, Usuario obj) {
        try {
            System.out.println(obj.toString());
            UsuarioController.update(id, obj);
            return Response.ok((Object) obj).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/insert")
    public Response saveJson(Usuario obj) {
        try {
            System.out.println(obj.toString());
            obj.setId(UsuarioController.getListaUsuarios().size());
            UsuarioController.addUsuario(obj);
            return Response.ok((Object) obj).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }
}
