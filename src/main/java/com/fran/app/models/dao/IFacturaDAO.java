package com.fran.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.fran.app.models.entities.Factura;

public interface IFacturaDAO extends CrudRepository<Factura, Long> {

}
