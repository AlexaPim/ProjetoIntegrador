package com.generation.carol.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_tema")
public class Tema {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@NotBlank
	@Size(min = 5, max = 255, message = "O nome deve conter de {min} a {max} caracteres.")
	private String nome;

	@NotNull
	@NotBlank

	@Size(min = 5, max = 1024, message = "A descrição deve conter de {min} a {max} caracteres.")
	private String descricao;

	@NotNull
	private int qntd_post;

	@NotNull
	private int relevante;

	@OneToMany(mappedBy = "tema", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JsonIgnore
//	@JsonIgnoreProperties("tema")
	private List<Postagem> postagens;

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

	public List<Postagem> getPostagens() {
		return postagens;
	}

	public void setPostagens(List<Postagem> postagens) {
		this.postagens = postagens;
	}

}
