package com.generation.carol.service;

import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.generation.carol.entities.Usuario;
import com.generation.carol.entities.UsuarioLogin;
import com.generation.carol.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Usuario> listarUsuarios() {

		return usuarioRepository.findAll();

	}

	public Optional<Usuario> buscarUsuarioId(long id) {

		return usuarioRepository.findById(id);

	}

	public Usuario cadastrarUsuario(Usuario usuario) {

		if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent())
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário já existe!", null);

		int idade = Period.between(usuario.getDataNascimento(), LocalDate.now()).getYears();

		if (idade < 18)
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário menor de 18 anos", null);

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		String senhaEncoder = encoder.encode(usuario.getSenha());
		usuario.setSenha(senhaEncoder);
		return usuarioRepository.save(usuario);
	}

	public Optional<UsuarioLogin> Logar(Optional<UsuarioLogin> user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Usuario> usuario = usuarioRepository.findByEmail(user.get().getEmail());

		if (usuario.isPresent()) {
			if (encoder.matches(user.get().getSenha(), usuario.get().getSenha())) {

				String auth = user.get().getEmail() + ":" + user.get().getSenha();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);
				user.get().setId(usuario.get().getId());
				user.get().setNome(usuario.get().getNome());
				user.get().setSenha(usuario.get().getSenha());
				user.get().setToken(authHeader);
				user.get().setFoto(usuario.get().getFoto());
				user.get().setTipo(usuario.get().getTipo());

				return user;
			}
		}
		return null;
	}

	public Optional<Usuario> atualizarUsuario(Usuario usuario) {
		if (usuarioRepository.findById(usuario.getId()).isPresent()) {

			Optional<Usuario> buscaUsuario = usuarioRepository.findByEmail(usuario.getEmail());

			if (buscaUsuario.isPresent()) {

				if (buscaUsuario.get().getId() != usuario.getId())
					throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário já existe!", null);
			}

			int idade = Period.between(usuario.getDataNascimento(), LocalDate.now()).getYears();

			if (idade < 18)
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário menor de 18 anos", null);

			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

			String senhaEncoder = encoder.encode(usuario.getSenha());
			usuario.setSenha(senhaEncoder);

			return Optional.of(usuarioRepository.save(usuario));

		} else {

			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado!", null);

		}

	}
}
