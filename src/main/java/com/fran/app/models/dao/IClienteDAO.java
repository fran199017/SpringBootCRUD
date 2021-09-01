package com.fran.app.models.dao;

import java.util.List;

import com.fran.app.models.entities.Cliente;

public interface IClienteDAO {

	public List<Cliente> findAll();
	
	public void guardarClientes(Cliente cliente);
	
	public Cliente findOne(Long id);
	
	public void delete(Long id);
		
}
