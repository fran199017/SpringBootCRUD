package com.fran.app.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fran.app.models.entities.Cliente;
import com.fran.app.models.service.IClienteService;
import com.fran.app.util.paginator.PageRender;

@Controller
@SessionAttributes("cliente")
public class ClienteController {

	@Autowired
	private IClienteService clienteService;
	
	@GetMapping(value="/ver/{id}")
	public String ver(@PathVariable(value="id") Long id, Map<String,Object> model, RedirectAttributes flash) {
		
		Cliente cliente= clienteService.findOne(id);
		if(cliente==null) {
			flash.addFlashAttribute("error","El cliente no existe en la BBDD");
			return "redirect:/listar";
		}
		model.put("cliente", cliente);
		model.put("titulo","Detalle Cliente: " + cliente.getNombre());
		
		return "ver";
	}
	
	@RequestMapping(value="/listar", method= RequestMethod.GET)
	public String listar(@RequestParam(name="page", defaultValue="0")  int page, Model model) {
		
		//Llamamos a Pageable donde decimos el numero de registros, 4.
		Pageable pageRequest= PageRequest.of(page, 5);
		
		Page<Cliente> clientes= clienteService.findAll(pageRequest);
			
		PageRender<Cliente> pageRender= new PageRender<>("/listar", clientes);
		model.addAttribute("titulo","Listado de clientes");
		model.addAttribute("clientes", clientes);
		model.addAttribute("page", pageRender);
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
	 public String guardar(@Valid Cliente cliente, BindingResult result, Model model, @RequestParam("file") MultipartFile foto, RedirectAttributes flash, SessionStatus status) {
		 if(result.hasErrors()) {
			 model.addAttribute("titulo", "Formulario de Cliente");
			 return "formulario";			 
		 }	 
		 
		 if(!foto.isEmpty()) {
			 
			 String uniqueFilename= UUID.randomUUID().toString() + "_" + foto.getOriginalFilename();
			 Path rootPath= Paths.get("uploads").resolve(uniqueFilename);
			 
			 Path rootAbsolutPath= rootPath.toAbsolutePath();
			 try {
				Files.copy(foto.getInputStream(), rootAbsolutPath);
				flash.addFlashAttribute("info", "Has subido correctamente la foto");
				
				cliente.setFoto(uniqueFilename);
			} catch (IOException e) {
				e.printStackTrace();
			}
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
			 Cliente cliente= clienteService.findOne(id);
			 clienteService.delete(id);
			 flash.addFlashAttribute("success", "Cliente eliminado con exito");
		
			 Path rootPath= Paths.get("uploads").resolve(cliente.getFoto()).toAbsolutePath();
			 File archivo= rootPath.toFile();
			 
			 if(archivo.exists() && archivo.canRead()) { 
				 if(archivo.delete()) {
					 flash.addFlashAttribute("info", "Foto eliminada con exito!");
				 }
					 
			 }
		 }
		 
		 
		 	
		 return "redirect:/listar";
	 }
	 
}
