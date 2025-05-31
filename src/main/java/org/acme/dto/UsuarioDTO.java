package org.acme.dto;

import java.time.LocalDate;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RegisterForReflection
public class UsuarioDTO {

	public UsuarioDTO(Long id, String nome, Integer idade, LocalDate dataAniversario, String login, String senha,
			Boolean flagAtivo) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.dataAniversario = dataAniversario;
		this.login = login;
		this.senha = senha;
		this.flagAtivo = flagAtivo;
	}

	private Long id;

	private String nome;

	private Integer idade;

	private LocalDate dataAniversario; 

	private String login; 

	private String senha;

	private Boolean flagAtivo;

}
