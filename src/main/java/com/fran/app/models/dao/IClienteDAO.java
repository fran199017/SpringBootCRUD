package com.fran.app.models.dao;

import org.springframework.data.repository.CrudRepository;
import com.fran.app.models.entities.Cliente;


public interface IClienteDAO extends CrudRepository<Cliente, Long> {
		
}
