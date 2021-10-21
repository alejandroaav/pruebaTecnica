package service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ClientesDao;
import dao.ClientesDaoMongo;
import model.Cliente;
import model.ClienteMongo;

@Service
public class ClientesServiceImpl implements ClientesService {
	@Autowired
	ClientesDao dao;
	@Autowired
	ClientesDaoMongo daoMongo;
	
	public Cliente obtenerClientesPorRut(String rut) {
		return dao.findByRut(rut);
	}
	
	public ClienteMongo findClienteMongo(String rut) {
		return daoMongo.findByRut(rut);
	}
	
	public List<Cliente> obtenerClientes() {
		return dao.findAll();
	}


	public boolean guardarCliente(Cliente cliente){
		if(cliente==null || cliente.getRut().isEmpty()) {
			return false;
		}
		
		try {
			Cliente c = dao.findByRut(cliente.getRut());
			
			if (c!=null) {
				return false;
			}else {
				dao.save(cliente);
			}
			
		}catch(Exception e) {
			return e.equals(e);
		}
		return true;
	}
	
	public boolean editarCliente(Cliente cliente) {
		if(cliente==null || cliente.getRut().isEmpty()) {
			return false;
		}
		
		try {
			Cliente c1 = dao.findByRut(cliente.getRut());
			
			if(c1==null) {
				//no existe el cliente, no se puede editar
				return false;
			}
			
			List<Cliente> clients = dao.findAll();
			
			for(Cliente c:clients) {
				if(c.getCorreo().equals(cliente.getCorreo())) {
					//no puede ingresar un correo que ya exista en otro cliente previamente
					return false;
				}
			}
			
			dao.save(cliente);
			
		}catch(Exception e) {
			return e.equals(e);
		}
		return true;
	}
	
	public boolean borrarCliente(String rut) {
		Cliente client = dao.findByRut(rut);
		
		if(client==null) {
			//no puede eliminar, no existe el registro
			return false;
		}
		
		try {
			dao.delete(client);
		}catch(Exception e) {
			return e.equals(e);
		}
		return true;
	}

}
