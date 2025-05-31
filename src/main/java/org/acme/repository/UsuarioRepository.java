package org.acme.repository;

import java.util.List;

import org.acme.dto.UsuarioDTO;
import org.acme.model.Usuario;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;

public interface UsuarioRepository extends PanacheRepository<Usuario> {

	Uni<Long> usuarioExiste(Long id, String login);

	Uni<List<UsuarioDTO>> listarAtivos();

	Uni<List<UsuarioDTO>> listarPorNome(String nome);

}
