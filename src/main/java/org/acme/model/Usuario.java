package org.acme.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_usuario")
@Getter
@Setter
public class Usuario {
	
	@Id
	@Column(name = "id_usuario")
	@SequenceGenerator(name = "GenUsuario", sequenceName = "gen_usuario", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator = "GenUsuario")
	private Long id;
	
	@Column(name = "tx_nome")
	private String nome;
	
	@Column(name = "nr_idade")
	private Integer idade;
	
	@Column(name = "dt_aniversario")
	private LocalDate dataAniversario; 
	
	@Column(name = "tx_login")
	private String login; 
	
	@Column(name = "tx_senha")
	private String senha;
	
	@Column(name = "fl_ativo")
	private Boolean flagAtivo;

}
