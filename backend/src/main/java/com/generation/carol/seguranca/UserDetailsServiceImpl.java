package com.generation.carol.seguranca;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.generation.carol.entities.Usuario;
import com.generation.carol.repositories.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<Usuario> user = usuarioRepository.findByEmail(userName);
		user.orElseThrow(() -> new UsernameNotFoundException(userName + " not found."));
		return user.map(UserDetailsImpl::new).get();
	}
}
