package com.franrodriguez.springboot.backend.apirest.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.franrodriguez.springboot.backend.apirest.app.models.dao.IClienteDao;
import com.franrodriguez.springboot.backend.apirest.app.models.entity.Cliente;

@Service
public class ClienteService implements IClienteService {
	
	@Autowired
	private IClienteDao clienteDao;

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return (List<Cliente>) clienteDao.findAll();
	}

}
