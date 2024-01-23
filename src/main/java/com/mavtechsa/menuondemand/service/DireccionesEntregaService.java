package com.mavtechsa.menuondemand.service;

import com.mavtechsa.menuondemand.domain.dto.ClienteDTO;
import com.mavtechsa.menuondemand.domain.dto.DireccionesEntregaDTO;
import com.mavtechsa.menuondemand.domain.model.Cliente;
import com.mavtechsa.menuondemand.domain.model.DireccionesEntrega;

import java.util.List;
import java.util.Optional;

public interface DireccionesEntregaService {

    DireccionesEntregaDTO crearDireccionEntrega(DireccionesEntregaDTO direccionEntrega);

    DireccionesEntregaDTO actualizarDireccionEntrega(DireccionesEntregaDTO direccionEntrega, Long id_direccion);
    List<DireccionesEntregaDTO> obtenerTodasLasDireccionesEntregaDeCliente(Long id_cliente);
    Optional<DireccionesEntregaDTO> obtenerDireccionEntregaActiva(Cliente cliente);
    public void asignarDireccion(DireccionesEntrega direccion,Cliente cliente);
    void eliminarDireccionEntrega (Long id_direccion);
    boolean existByDireccion (String direccion);


    }


