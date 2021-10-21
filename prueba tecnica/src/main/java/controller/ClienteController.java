package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Cliente;
import model.ClienteMongo;
import service.ClientesService;

@CrossOrigin(origins="*")
@RestController
public class ClienteController {
	
	@Autowired
	ClientesService service;

	@GetMapping (value ="obtenerClientes/{rut}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Cliente getClientesByRut (@PathVariable("rut") String rut) {
		return service.obtenerClientesPorRut(rut);
		
	}
	
	@GetMapping (value ="obtenerClientes", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Cliente> getClientes () {
		return service.obtenerClientes();
		
	}

	@PostMapping (value= "guardarCliente")
	public boolean saveCliente (@RequestBody Cliente cliente) {
		return service.guardarCliente(cliente);
	}
	
	@PutMapping (value= "editarCliente")
	public boolean updateCliente (@RequestBody Cliente cliente) {
		return service.editarCliente(cliente);
	}
	
	@DeleteMapping (value= "borrarCliente/{rut}")
	public boolean deleteCliente (@PathVariable("rut") String rut) {
		return service.borrarCliente(rut);
	}
	
	@GetMapping (value ="obtenerClienteMongo/{rut}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ClienteMongo findClienteMongo (@PathVariable("rut") String rut) {
		return service.findClienteMongo(rut);
	}
}

