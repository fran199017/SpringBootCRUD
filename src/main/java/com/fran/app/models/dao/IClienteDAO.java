package com.fran.app.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.fran.app.models.entities.Cliente;


public interface IClienteDAO extends PagingAndSortingRepository<Cliente, Long> {
		
}
