package com.generation.carol.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "O atributo nome é obrigatório")
	@NotBlank(message = "O atributo nome não pode ser vazio")
	@Size(min = 5, max = 255, message = "O nome deve conter no minimo {min} caracteres.")
	private String nome;

	@ApiModelProperty(example = "email@email.com.br")
	@NotNull(message = "O atributo e-mail é obrigatório")
	@NotBlank(message = "O atributo e-mail não pode ser vazio")
	@Size(min = 5, max = 255, message = "O e-mail deve conter no minimo {min} caracteres.")
	private String email;

	@NotNull(message = "O atributo senha é obrigatório")
	@NotBlank(message = "O atributo senha não pode ser vazio")
	@Size(min = 5, max = 255, message = "A senha deve conter no minimo {min} caracteres.")
	private String senha;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("usuario")
	private List<Postagem> postagens;

	@Column(name = "dt_nascimento")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataNascimento;

	public Usuario(Long id, String nome, String email, String senha, LocalDate dataNascimento) {

		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.dataNascimento = dataNascimento;
	}

	public Usuario() {

	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Postagem> getPostagens() {
		return postagens;
	}

	public void setPostagens(List<Postagem> postagens) {
		this.postagens = postagens;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
