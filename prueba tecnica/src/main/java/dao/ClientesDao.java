package dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import model.Cliente;

public interface ClientesDao extends JpaRepository<Cliente, Integer> {
	
	Cliente findByRut(String rut);

}
