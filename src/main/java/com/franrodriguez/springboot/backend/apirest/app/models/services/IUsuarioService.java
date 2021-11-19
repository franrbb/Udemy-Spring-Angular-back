package com.franrodriguez.springboot.backend.apirest.app.models.services;

import com.franrodriguez.springboot.backend.apirest.app.models.entity.Usuario;

public interface IUsuarioService {
	
	public Usuario findByUsername(String username);

}
