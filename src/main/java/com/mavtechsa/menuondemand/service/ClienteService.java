package com.mavtechsa.menuondemand.service;

import com.mavtechsa.menuondemand.domain.dto.ClienteDTO;
import com.mavtechsa.menuondemand.domain.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface ClienteService {
    List<ClienteDTO> obtenerTodosLosClientes();
    Optional<ClienteDTO> obtenerClientePorId(Long id);
    List<ClienteDTO> obtenerClientesPorNombreYapellido(String nombreYpellido);
    ClienteDTO crearCliente(ClienteDTO clienteDTO);
    ClienteDTO actualizarCliente(Long id,ClienteDTO clienteDTO);

    void eliminarCliente(Long id);
    boolean existByNombreYapellido(String nombreYapellido);
     boolean existByCorreo(String correo);

}
