package com.mavtechsa.menuondemand.domain.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mavtechsa.menuondemand.domain.model.DireccionesEntrega;
import lombok.*;
import org.mapstruct.Mapping;

import javax.management.ConstructorParameters;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteDTO {

    private Long id_cliente;

    private String nombreYapellido;

    private int cel;

    private String correo;

    private String direccion;
    private List<DireccionesEntregaDTO> direccionesEntrega;

    private boolean eliminado;

    public ClienteDTO(ClienteDTO clienteDTO) {
    }
}