package com.fran.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fran.app.models.entities.Cliente;
import com.fran.app.models.service.IClienteService;

@Controller
@SessionAttributes("cliente")
public class ClienteController {

	@Autowired
	private IClienteService clienteService;
	
	@RequestMapping(value="/listar", method= RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo","Listado de clientes");
		model.addAttribute("clientes",clienteService.findAll());
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
	 public String guardar(@Valid Cliente cliente, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status) {
		 if(result.hasErrors()) {
			 model.addAttribute("titulo", "Formulario de Cliente");
			 return "formulario";			 
		 }	 
		 String mensajeFlash= (cliente.getId() != null) ? "Cliente editado con exito!" : "Cliente creado con exito!" ;
		 
		 clienteService.save(cliente);
		 status.setComplete();
		 flash.addFlashAttribute("success", mensajeFlash );
		 return "redirect:listar"; 		 		
	 }
	 
	 @RequestMapping(value="/form/{id}")
	 public String editar(@PathVariable(value="id") Long id, Map<String,Object> model, RedirectAttributes flash) {
		 
		 Cliente cliente=null;
		 
		 if(id>0) {
			 cliente=clienteService.findOne(id);
			 if(cliente== null) {
				 flash.addFlashAttribute("error", "El ID del cliente no existe en la BBDD");
				 return"redirect:/listar";
			 }
		 }else {
			 flash.addFlashAttribute("error", "El ID del cliente no puede ser 0");
			 return"redirect:/listar";
		 }
		 model.put("cliente", cliente);
		 model.put("titulo", "Editar Cliente");
		 return "formulario";		 
	 }
	 
	 @RequestMapping(value="/eliminar/{id}")
	 public String eliminar(@PathVariable(value="id") Long id,  RedirectAttributes flash) {
		 
		 if(id>0) { 
			 clienteService.delete(id);
			 flash.addFlashAttribute("success", "Cliente eliminado con exito");
			 } 
		 
		 	
		 return "redirect:/listar";
	 }
	 
}
