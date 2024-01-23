package com.mavtechsa.menuondemand.domain.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mavtechsa.menuondemand.domain.dto.ClienteDTO;
import com.mavtechsa.menuondemand.domain.model.Cliente;
import com.mavtechsa.menuondemand.domain.model.DireccionesEntrega;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DireccionesEntregaDTO {

    private Long id_direccion;
    private Long id_cliente;
    private String direccion;
    private boolean activa;
    private boolean eliminado;


}
