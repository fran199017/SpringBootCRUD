package com.fran.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fran.app.models.dao.IClienteDAO;

@Controller
public class ClienteController {

	@Autowired
	private IClienteDAO clienteDao;
	
	@RequestMapping(value="/listar", method= RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo","Listado de clientes");
		model.addAttribute("clientes",clienteDao.findAll());
		return "listar";
	}
}
