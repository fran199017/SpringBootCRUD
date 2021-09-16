package com.fran.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fran.app.models.entities.Cliente;
import com.fran.app.models.entities.Factura;
import com.fran.app.models.entities.Producto;

public interface IClienteService {
	
	public List<Cliente> findAll();
	
	public Page<Cliente> findAll(Pageable pageable);
	
	public void save(Cliente cliente);
	
	public Cliente findOne(Long id);
	
	public void delete(Long id);
	 
	public List<Producto> findByNombre(String term);
	
	public Producto findProductoById(Long id);
	
	public void saveFactura(Factura factura);
	
	public Factura findFacturaById(Long id);
		
}
