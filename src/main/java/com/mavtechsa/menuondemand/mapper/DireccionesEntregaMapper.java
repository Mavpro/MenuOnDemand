package com.mavtechsa.menuondemand.mapper;


import com.mavtechsa.menuondemand.domain.dto.ClienteDTO;
import com.mavtechsa.menuondemand.domain.dto.DireccionesEntregaDTO;
import com.mavtechsa.menuondemand.domain.model.Cliente;
import com.mavtechsa.menuondemand.domain.model.DireccionesEntrega;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface DireccionesEntregaMapper {

    DireccionesEntregaMapper INSTANCE = Mappers.getMapper(DireccionesEntregaMapper.class);
    @Mapping(source = "id_direccion" ,target = "id_direccion")

    @Mapping(source = "id_cliente" ,target = "cliente.id_cliente")

    DireccionesEntrega toDireccionesEntrega(DireccionesEntregaDTO direccionEntregaDTO);
    @Mapping(source = "id_direccion" ,target = "id_direccion")

    @Mapping(source = "cliente.id_cliente" ,target = "id_cliente")

    DireccionesEntregaDTO toDireccionesEntregaDTO(DireccionesEntrega direccionEntrega);

    List<DireccionesEntregaDTO> toDireccionDtoList(List<DireccionesEntrega> direccionesEntrega);

}