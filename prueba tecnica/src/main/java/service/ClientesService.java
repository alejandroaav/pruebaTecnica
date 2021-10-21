package service;

import java.util.List;

import model.Cliente;
import model.ClienteMongo;

public interface ClientesService {
	Cliente obtenerClientesPorRut(String rut);
	List<Cliente> obtenerClientes();
	boolean guardarCliente(Cliente cliente);
	boolean editarCliente(Cliente cliente);
	boolean borrarCliente(String rut);
	ClienteMongo findClienteMongo(String rut);
}
