package com.franrodriguez.springboot.backend.apirest.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.franrodriguez.springboot.backend.apirest.app.models.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long>{

}
