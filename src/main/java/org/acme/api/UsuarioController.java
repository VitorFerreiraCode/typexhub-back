package org.acme.api;

import java.util.List;

import org.acme.dto.UsuarioDTO;
import org.acme.dto.UsuarioSalvarDTO;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;

@Path("/usuario")
public interface UsuarioController {

	@GET
	@Path("/listar")
	public Uni<List<UsuarioDTO>> listar(@QueryParam("nome") String nome);
	
	@POST
	@Path("/salvar")
	public Uni<Void> salvar(UsuarioSalvarDTO usuario);
	
	@GET
	@Path("/adquirir/{codigoUsuario}")
	public Uni<UsuarioDTO> adquirir(@PathParam("codigoUsuario") Long codigoUsuario);
	
	@DELETE
	@Path("/excluir/{codigoUsuario}")
	public Uni<Void> excluir(@PathParam("codigoUsuario") Long codigoUsuario);
}
