package com.unab.app.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.unab.app.interfaces.IClienteService;
import com.unab.app.models.Cliente;

@RestController
@RequestMapping(value="/clientes")
public class ClienteController {
	
	@Autowired
	private IClienteService iclienteService;
	
	@GetMapping("/listar")
	public List<Cliente> getClientes(){
		return iclienteService.findAll();
	}
	@GetMapping("/listarPageable")	
	public Page<Cliente> findAll(){
		Pageable pageable=Pageable.ofSize(15);
		return iclienteService.findAll(pageable);
	}
	@PostMapping("/save")
	public Cliente save(@RequestBody Cliente cliente) {
		iclienteService.save(cliente);
		return cliente;
	}
	@GetMapping("/getCliente/(id)")
	public Cliente findOne(@PathVariable("id") Long id) {
		return iclienteService.findOne(id);
	}
	@GetMapping("/delete/(id)")
	public ResponseEntity<String> deleteCliente(@PathVariable("id") Long id){
		return iclienteService.delete(id);
	}
}