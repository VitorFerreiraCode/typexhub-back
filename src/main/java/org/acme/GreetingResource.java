package org.acme;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy Reactive";
    }
    
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String cadastroUsuario() {
    	
    	String usuario = "Angelica Pagani";
    	
    	return "Usuario criado: " + usuario;
    }
    
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public String deletarUsuario() {
    	
    	return "Usuario deletado";
    }
 
}
