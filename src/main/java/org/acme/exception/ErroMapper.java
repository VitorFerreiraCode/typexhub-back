package org.acme.exception;

import org.acme.dto.ExceptionDTO;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ErroMapper implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable exception) {
		
		ExceptionDTO exceptionDto = new ExceptionDTO();
		exceptionDto.setMensagem(exception.getMessage());
		
		return Response.status(500).entity(exceptionDto).build();
	}

}
