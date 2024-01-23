package com.mavtechsa.menuondemand.service.impl;

import com.mavtechsa.menuondemand.domain.dto.ClienteDTO;
import com.mavtechsa.menuondemand.domain.dto.DireccionesEntregaDTO;
import com.mavtechsa.menuondemand.domain.model.Cliente;
import com.mavtechsa.menuondemand.domain.model.DireccionesEntrega;
import com.mavtechsa.menuondemand.mapper.ClienteMapper;
import com.mavtechsa.menuondemand.mapper.DireccionesEntregaMapper;
import com.mavtechsa.menuondemand.repositories.DireccionesEntregaRepository;
import com.mavtechsa.menuondemand.service.DireccionesEntregaService;
import jakarta.annotation.Resource;
import org.mapstruct.ap.shaded.freemarker.core.ReturnInstruction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DireccionesEntregaServiceImpl implements DireccionesEntregaService {
    @Resource
    private final DireccionesEntregaRepository direccionesEntregaRepository;
    private final DireccionesEntregaMapper direccionesEntregaMapper;

    @Autowired
    public DireccionesEntregaServiceImpl(DireccionesEntregaRepository direccionesEntregaRepository, DireccionesEntregaMapper direccionesEntregaMapper, ClienteMapper clienteMapper) {
        this.direccionesEntregaRepository = direccionesEntregaRepository;
        this.direccionesEntregaMapper = direccionesEntregaMapper;
    }

    @Override
    public DireccionesEntregaDTO crearDireccionEntrega(DireccionesEntregaDTO direccionEntrega) {
        DireccionesEntrega direcc = direccionesEntregaMapper.toDireccionesEntrega(direccionEntrega);
        direcc = direccionesEntregaRepository.save(direcc); // para guardar la entida manejada
        return direccionesEntregaMapper.toDireccionesEntregaDTO(direcc);
    }

    @Override
    public DireccionesEntregaDTO actualizarDireccionEntrega(DireccionesEntregaDTO direccionEntrega, Long id_direccion) {
        if (direccionesEntregaRepository.existsById(id_direccion)) ;
        DireccionesEntrega direccion = direccionesEntregaMapper.toDireccionesEntrega(direccionEntrega);
        direccion = direccionesEntregaRepository.save(direccion);
        return direccionesEntregaMapper.toDireccionesEntregaDTO(direccion);
    }

    @Override
    public List<DireccionesEntregaDTO> obtenerTodasLasDireccionesEntregaDeCliente(Long id_cliente) {
        List<DireccionesEntrega> direccionesObtenidas = (List<DireccionesEntrega>) direccionesEntregaRepository.findAll();
        return direccionesObtenidas.stream().filter(direcc -> direcc.getCliente().getId_cliente().equals(id_cliente))
                .map(direccionesEntregaMapper::toDireccionesEntregaDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<DireccionesEntregaDTO> obtenerDireccionEntregaActiva(Cliente cliente) {
        Optional<DireccionesEntrega> direccion = direccionesEntregaRepository.findByClienteAndActiva(cliente, true);
        return direccion.map(direccionesEntregaMapper::toDireccionesEntregaDTO);

    }


    @Override
    public void eliminarDireccionEntrega(Long id_direccion) {
        Optional<DireccionesEntrega> direccionOpt = direccionesEntregaRepository.findById(id_direccion);
        if (direccionOpt.isPresent()) {
            DireccionesEntrega direccionesEntrega = direccionOpt.get();
            direccionesEntrega.setEliminado(true);
        }
    }

    @Override
    public boolean existByDireccion(String direccion) {
        return direccionesEntregaRepository.existsByDireccion(direccion);
    }

    @Override
    public void asignarDireccion(DireccionesEntrega direccion,Cliente cliente) {
       direccion.setCliente(cliente);
       direccionesEntregaRepository.save(direccion);

    }
}
