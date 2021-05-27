package com.franrodriguez.springboot.backend.apirest.app.models.services;

import java.util.List;

import com.franrodriguez.springboot.backend.apirest.app.models.entity.Cliente;

public interface IClienteService {
	
	public List<Cliente> findAll();

}
