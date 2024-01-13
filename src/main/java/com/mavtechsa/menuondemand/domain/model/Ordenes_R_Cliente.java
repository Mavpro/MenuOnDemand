package com.mavtechsa.menuondemand.domain.model;

import com.mavtechsa.menuondemand.domain.model.keys.Orden_R_Cliente_PK;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "ORDEN_R_CLIENTE")
@Data
public class Ordenes_R_Cliente implements Serializable {
        private static final long serialVersionUID = 1L;

        @EmbeddedId
        private Orden_R_Cliente_PK orden_r_cliente_pk;

        @ManyToOne
        @JoinColumn(name = "id_orden", referencedColumnName = "id_orden", insertable = false, updatable = false)
        private OrdenDelDia ordenC;

        @ManyToOne
        @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente", insertable = false, updatable = false)
        private Cliente clienteO;

        private boolean eliminado;


    }
