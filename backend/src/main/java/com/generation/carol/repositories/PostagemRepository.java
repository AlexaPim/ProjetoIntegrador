package com.generation.carol.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.carol.entities.Postagem;
import com.generation.carol.entities.Tema;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {

	public List<Postagem> findAllByTitleContainingIgnoreCase(String title);	
}
