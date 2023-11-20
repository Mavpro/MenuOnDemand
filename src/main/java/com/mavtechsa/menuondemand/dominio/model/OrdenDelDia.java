package com.mavtechsa.menuondemand.dominio.model;

import com.mavtechsa.menuondemand.dominio.model.enums.EstadosOrden;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.security.PrivateKey;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class OrdenDelDia {
    @Id
    private Long id_orden;
    private LocalDate fecha;

    @OneToMany(mappedBy = "orden")
    private List<Menu> menues;

    private EstadosOrden estadoOrden;

}
