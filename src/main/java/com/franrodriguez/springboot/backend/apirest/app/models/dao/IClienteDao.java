package com.franrodriguez.springboot.backend.apirest.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.franrodriguez.springboot.backend.apirest.app.models.entity.Cliente;

public interface IClienteDao extends JpaRepository<Cliente, Long>{

}
