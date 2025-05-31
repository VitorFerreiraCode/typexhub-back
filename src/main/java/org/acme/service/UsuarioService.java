package org.acme.service;

import java.util.List;

import org.acme.dto.UsuarioDTO;
import org.acme.dto.UsuarioSalvarDTO;

import io.smallrye.mutiny.Uni;

public interface UsuarioService {

	public Uni<List<UsuarioDTO>> listarUsuario(String nome);

	public Uni<UsuarioDTO> adquirir(Long codigoUsuario);

	public Uni<Void> salvar(UsuarioSalvarDTO usuario);

	public Uni<Void> excluir(Long codigoUsuario);
}
