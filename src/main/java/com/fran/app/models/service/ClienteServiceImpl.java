package com.fran.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fran.app.models.dao.IClienteDAO;
import com.fran.app.models.dao.IProductoDAO;
import com.fran.app.models.entities.Cliente;
import com.fran.app.models.entities.Producto;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteDAO clienteDAO;
	
	@Autowired
	private IProductoDAO productoDAO;
	
	@Override
	@Transactional(readOnly=true)
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteDAO.findAll();
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		clienteDAO.save(cliente);
	}

	@Override
	@Transactional(readOnly=true)
	public Cliente findOne(Long id) {
		
		return clienteDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		clienteDAO.deleteById(id);	
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Cliente> findAll(Pageable pageable) {
		return clienteDAO.findAll(pageable);
		
	}

	@Override
	@Transactional(readOnly=true)
	public List<Producto> findByNombre(String term) {
		
		return productoDAO.findByNombreLikeIgnoreCase("%"+term+"%");
	}

}
