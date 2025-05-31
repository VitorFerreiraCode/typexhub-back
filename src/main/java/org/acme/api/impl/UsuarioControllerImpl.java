package org.acme.api.impl;

import java.util.List;

import org.acme.api.UsuarioController;
import org.acme.dto.UsuarioDTO;
import org.acme.dto.UsuarioSalvarDTO;
import org.acme.service.UsuarioService;

import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;

public class UsuarioControllerImpl implements UsuarioController {

	@Inject
	UsuarioService usuarioService;
	
	@Override
	public Uni<List<UsuarioDTO>> listar(String nome) {
		
		return usuarioService.listarUsuario(nome);
	}

	@Override
	public Uni<Void> salvar(UsuarioSalvarDTO usuario) {
		
		return usuarioService.salvar(usuario);
	}

	@Override
	public Uni<UsuarioDTO> adquirir(Long codigoUsuario) {
		
		return usuarioService.adquirir(codigoUsuario);
	}

	@Override
	public Uni<Void> excluir(Long codigoUsuario) {
		
		return usuarioService.excluir(codigoUsuario);
	}

}
