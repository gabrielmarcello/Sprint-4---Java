package resources;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import beans.Usuario;
import bo.UsuarioBO;

@Path("/usuario")
public class UsuarioResource {
	
	private UsuarioBO usuarioBO = new UsuarioBO();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastroRs(Usuario usuario, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
		usuarioBO.inserirBO(usuario);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder(); //recebe a informação do front (página)
		builder.path(Integer.toString(usuario.getId())); //identifica o id do campo (String)
		return Response.created(builder.build()).build(); //composição -> caminho (carrregar o que foi carregado) - http -> 200
	}
	
	//consultar (GET)
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario selecionarRs(@PathParam("id") int id) throws ClassNotFoundException, SQLException{
		return usuarioBO.exibirPorIdBO(id);
	}

}
