package com.franrodriguez.springboot.backend.apirest.app.models.services;

import org.springframework.transaction.annotation.Transactional;

import com.franrodriguez.springboot.backend.apirest.app.models.dao.IUsuarioDao;
import com.franrodriguez.springboot.backend.apirest.app.models.entity.Usuario;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService{
	
	private Logger log = org.slf4j.LoggerFactory.getLogger(UsuarioService.class);
	
	@Autowired
	private IUsuarioDao usuarioDao;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = usuarioDao.findByUsername(username);
		
		if(usuario == null) {
			log.error("Error en el login: no existe el usuaio " +username+ " en el sistema");
			throw new UsernameNotFoundException("Error en el login: no existe el usuaio " +username+ " en el sistema");
		}
		
		List<GrantedAuthority> authories = usuario.getRoles()
				.stream()
				.map(role -> new SimpleGrantedAuthority(username))
				.peek(authority -> log.info("Role " +authority.getAuthority()))
				.collect(Collectors.toList());
		
		return new User(usuario.getUsername(), usuario.getPassword(), usuario.isEnabled(), true, true, true, authories);
	}

}
