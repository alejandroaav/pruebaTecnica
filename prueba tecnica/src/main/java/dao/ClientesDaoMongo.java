package dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import model.Cliente;
import model.ClienteMongo;

@Repository
public interface ClientesDaoMongo extends MongoRepository<ClienteMongo, String> {
	ClienteMongo findByRut(String rut);

}
