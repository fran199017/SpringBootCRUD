package com.fran.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fran.app.models.dao.IClienteDAO;
import com.fran.app.models.entities.Cliente;

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
	
	@RequestMapping(value="/form")
	public String insertarClientes(Map<String, Object> model) {
		Cliente cliente= new Cliente();
		model.put("cliente", cliente);
		model.put("titulo", "Formulario de Cliente");
		
		return "formulario";
	}
	
	 @RequestMapping(value="/form", method=RequestMethod.POST)
	 public String guardar(@Valid Cliente cliente, BindingResult result, Model model) {
		 if(result.hasErrors()) {
			 model.addAttribute("titulo", "Formulario de Cliente");
			 return "formulario";			 
		 }	 
		 
		 clienteDao.guardarClientes(cliente);
		 return "redirect:listar"; 
		 	
		
	 }
}
