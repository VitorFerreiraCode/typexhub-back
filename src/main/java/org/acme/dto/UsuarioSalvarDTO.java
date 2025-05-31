package org.acme.dto;

import java.time.LocalDate;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@RegisterForReflection
public class UsuarioSalvarDTO {

	private Long id;

	private String nome;

	private Integer idade;

	private LocalDate dataAniversario; 

	private String login; 

	private String senha;

	private Boolean flagAtivo;

}
