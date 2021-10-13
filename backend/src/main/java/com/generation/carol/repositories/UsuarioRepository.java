package com.generation.carol.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.carol.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	public Optional<Usuario> findByEmail(String email);

	public List<Usuario> findAllByNomeContainingIgnoreCase(String nomeParcial);

}
