package services;

import controller.EmprestimoController;
import controller.LivroController;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Emprestimo;
import model.Livro;

@Path("/emprestimo")
public class EmprestimoService {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/alugar")
    public Response alugarLivro(Emprestimo obj) {
        try {
            System.out.println(obj.toString());
            obj.setId(EmprestimoController.getList().size());
            EmprestimoController.addEmprestimo(obj);
            return Response.ok((Object) obj).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/devolver/{id}")
    public Response devolverLivro(Emprestimo obj) {
        try {
            System.out.println(obj.toString());
            obj.setId(EmprestimoController.getList().size());
            EmprestimoController.addEmprestimo(obj);
            return Response.ok((Object) obj).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

}
