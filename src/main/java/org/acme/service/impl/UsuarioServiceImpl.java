package org.acme.service.impl;

import java.util.List;

import org.acme.dto.UsuarioDTO;
import org.acme.dto.UsuarioSalvarDTO;
import org.acme.model.Usuario;
import org.acme.repository.UsuarioRepository;
import org.acme.service.UsuarioService;

import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.quarkus.panache.common.Parameters;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.WebApplicationException;

@ApplicationScoped
public class UsuarioServiceImpl implements UsuarioService {

	@Inject
	UsuarioRepository usuarioRepository;

	@Override
	public Uni<List<UsuarioDTO>> listarUsuario(String nome) {
		Uni<List<UsuarioDTO>> usuarios;
		if (nome == null || nome.isEmpty()) {
			usuarios = usuarioRepository.listarAtivos();
		} else {
			usuarios = usuarioRepository.listarPorNome(nome);
		}
		return usuarios;
	}

	@Override
	public Uni<UsuarioDTO> adquirir(Long codigoUsuario) {

		return usuarioRepository.find("id = :codigoUsuario", Parameters.with("codigoUsuario", codigoUsuario))
				.project(UsuarioDTO.class).firstResult();
	}

	@Override
	@WithTransaction
	public Uni<Void> salvar(UsuarioSalvarDTO usuario) {

		Uni<Long> usuarioEncontrado = usuarioRepository.usuarioExiste(usuario.getId(), usuario.getLogin());
		usuarioEncontrado = usuarioEncontrado.flatMap(usuarioCount -> {
			if (usuarioCount > 0) {
				return Uni.createFrom().failure(new WebApplicationException("Usuario ja existe"));
			}
			return Uni.createFrom().item(usuarioCount);

		});

		Uni<Usuario> uUsuarioBase = usuario.getId() != null ? usuarioRepository.findById(usuario.getId())
				: Uni.createFrom().item(new Usuario());

		uUsuarioBase = uUsuarioBase.flatMap(usuarioBase -> {

			usuarioBase.setNome(usuario.getNome());
			usuarioBase.setIdade(usuario.getIdade());
			usuarioBase.setDataAniversario(usuario.getDataAniversario());
			usuarioBase.setLogin(usuario.getLogin());
			usuarioBase.setSenha(usuario.getSenha());
			usuarioBase.setFlagAtivo(usuario.getFlagAtivo());

			return usuarioRepository.persist(usuarioBase);
		});
		Uni<Usuario> usuarioBaseFinal = uUsuarioBase;
		return usuarioEncontrado.flatMap(x -> usuarioBaseFinal.replaceWithVoid());
	}

	@Override
	@WithTransaction
	public Uni<Void> excluir(Long codigoUsuario) {

		return usuarioRepository.deleteById(codigoUsuario).replaceWithVoid();
	}

}
