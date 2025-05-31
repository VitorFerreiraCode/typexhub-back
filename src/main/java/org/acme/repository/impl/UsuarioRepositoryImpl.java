package org.acme.repository.impl;

import java.util.List;

import org.acme.dto.UsuarioDTO;
import org.acme.repository.UsuarioRepository;

import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.quarkus.panache.common.Parameters;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
@WithSession
public class UsuarioRepositoryImpl implements UsuarioRepository {

	@Override
	public Uni<Long> usuarioExiste(Long id, String login) {

		Long codigoUsuario = id != null ? id : 0L;

		return this.count("id != :id and login = :login", Parameters.with("id", codigoUsuario).and("login", login));
	}

	@Override
	public Uni<List<UsuarioDTO>> listarAtivos() {

		return this.find("flagAtivo = true").project(UsuarioDTO.class).list();
	}

	@Override
	public Uni<List<UsuarioDTO>> listarPorNome(String nome) {

		return this.find("nome like :nome", Parameters.with("nome", "%" + nome + "%")).project(UsuarioDTO.class).list();
	}

}
