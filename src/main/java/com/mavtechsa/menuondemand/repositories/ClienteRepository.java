package com.mavtechsa.menuondemand.repositories;

import com.mavtechsa.menuondemand.domain.model.Cliente;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    List<Cliente> findClienteByNombreYapellido(String nombreYapellido);
    Boolean existsByNombreYapellido(String nombreYapellido);
    Boolean existsByCorreo(String correo);




}