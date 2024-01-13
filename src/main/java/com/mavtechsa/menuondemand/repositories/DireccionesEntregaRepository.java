package com.mavtechsa.menuondemand.repositories;

import com.mavtechsa.menuondemand.domain.model.Cliente;
import com.mavtechsa.menuondemand.domain.model.DireccionesEntrega;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DireccionesEntregaRepository extends CrudRepository<DireccionesEntrega, Long> {
    List<DireccionesEntrega> findByDireccion(DireccionesEntrega direccion);
    Boolean existsByDireccion(String direString);

   Optional<DireccionesEntrega> findByClienteAndActiva(Cliente cliente, boolean activa);


}