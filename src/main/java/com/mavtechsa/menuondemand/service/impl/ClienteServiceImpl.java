package com.mavtechsa.menuondemand.service.impl;

import com.mavtechsa.menuondemand.domain.dto.ClienteDTO;
import com.mavtechsa.menuondemand.domain.model.Cliente;
import com.mavtechsa.menuondemand.mapper.ClienteMapper;
import com.mavtechsa.menuondemand.repositories.ClienteRepository;
import com.mavtechsa.menuondemand.service.ClienteService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ClienteServiceImpl implements ClienteService {
    @Resource
    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    @Override
    public List<ClienteDTO> obtenerTodosLosClientes() {
        List<Cliente> clientes = (List<Cliente>) clienteRepository.findAll();
        return clientes.stream().filter(cliente -> cliente.isEliminado()==false)
        .map(clienteMapper::toClienteDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ClienteDTO> obtenerClientePorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.filter(cliente1 -> !cliente1.isEliminado()).map(clienteMapper::toClienteDTO);
    }

    @Override
    public List<ClienteDTO> obtenerClientesPorNombreYapellido(String nombreYapellido) {
        List<Cliente> clientes = (List<Cliente>) clienteRepository.findClienteByNombreYapellido(nombreYapellido);
        return clientes.stream()
                .map(clienteMapper::toClienteDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ClienteDTO crearCliente(ClienteDTO clienteDTO) {
        Cliente cliente = clienteMapper.toCliente(clienteDTO); // me pasa del DTO a un Entity
        cliente = clienteRepository.save(cliente); //aca guardo el registro
        return clienteMapper.toClienteDTO(cliente); // finalmente mando la entidad guardada al return de tipo DTO
    }

    @Override
    public ClienteDTO actualizarCliente(Long id, ClienteDTO clienteDTO) {
        if(clienteRepository.existsById(id)){//si existe con el id
            Cliente cliente = clienteMapper.toCliente(clienteDTO); // paso del DTo a entity
            cliente = clienteRepository.save(cliente); // actualizo
            return clienteMapper.toClienteDTO(cliente);
        }
        return null; // si no existe no hago nada

    }

    @Override
    public void eliminarCliente(Long id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            cliente.setEliminado(true);
            clienteRepository.save(cliente);
        }
    }

    @Override
    public boolean existByNombreYapellido(String nombreYapellido) {
        return clienteRepository.existsByNombreYapellido(nombreYapellido);
    }

    @Override
    public boolean existByCorreo(String correo) {
        return clienteRepository.existsByCorreo(correo);
    }
}
