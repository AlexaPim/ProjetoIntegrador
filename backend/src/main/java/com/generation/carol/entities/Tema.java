package com.generation.carol.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_tema")
public class Tema {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 5, max = 255)
	private String nome;
	
	@NotNull
	@Size(min = 5, max = 1024)
	private String descricao;
	
	@NotNull
	private int qntd_post;
	
	@NotNull
	private int relevante;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQntd_post() {
		return qntd_post;
	}

	public void setQntd_post(int qntd_post) {
		this.qntd_post = qntd_post;
	}

	public int getRelevante() {
		return relevante;
	}

	public void setRelevante(int relevante) {
		this.relevante = relevante;
	}
}
