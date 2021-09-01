package com.fran.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fran.app.models.entities.Cliente;

@Repository
public class ClienteDAOImpl implements IClienteDAO {

	
	//Atributos
	@PersistenceContext
	private EntityManager em;
	
	
	
	//Methods
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("from Cliente").getResultList();
	}

	
	@Override
	@Transactional
	public void guardarClientes(Cliente cliente) {
		if(cliente.getId()!= null && cliente.getId()>0) {
			em.merge(cliente);
		}else {
		em.persist(cliente);	
		}
	}


	@Override
	@Transactional(readOnly=true)
	public Cliente findOne(Long id) {
		
		return em.find(Cliente.class, id);
	}


	@Override
	@Transactional
	public void delete(Long id) {
		em.remove(findOne(id));
		
	}

}
