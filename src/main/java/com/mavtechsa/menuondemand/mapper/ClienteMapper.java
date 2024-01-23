package com.mavtechsa.menuondemand.mapper;


import com.mavtechsa.menuondemand.domain.dto.ClienteDTO;
import com.mavtechsa.menuondemand.domain.dto.DireccionesEntregaDTO;
import com.mavtechsa.menuondemand.domain.model.Cliente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);
    @Mapping(source = "id_cliente" ,target = "id_cliente")

    Cliente toCliente(ClienteDTO clienteDTO);
    @Mapping(source = "id_cliente" ,target = "id_cliente")

    ClienteDTO toClienteDTO(Cliente cliente);

    List<ClienteDTO> toClienteDtoList(List<Cliente> clientes);


}