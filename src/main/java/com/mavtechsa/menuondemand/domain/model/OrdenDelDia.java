package com.mavtechsa.menuondemand.domain.model;

import com.mavtechsa.menuondemand.domain.model.enums.EstadosOrden;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class OrdenDelDia {
    @Id
    private Long id_orden;

    private LocalDate fecha;

    private EstadosOrden estadoOrden;

    private boolean eliminado;

}
