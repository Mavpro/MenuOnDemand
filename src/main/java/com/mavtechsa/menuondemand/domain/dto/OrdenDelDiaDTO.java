package com.mavtechsa.menuondemand.domain.dto;

import com.mavtechsa.menuondemand.domain.model.enums.EstadosOrden;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdenDelDiaDTO {

    private Long idOrden;
    private LocalDate fecha;
    private EstadosOrden estadoOrden;
    private boolean eliminado;

}
