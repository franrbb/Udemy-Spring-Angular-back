package com.franrodriguez.springboot.backend.apirest.app.models.services;

import java.util.List;

import com.franrodriguez.springboot.backend.apirest.app.models.entity.Cliente;

public interface IClienteService {
	
	public List<Cliente> findAll();
	
	public Cliente findById(Long id);
	
	public Cliente save(Cliente cliente);
	
	public void delete(Long id);

}
