package com.mavtechsa.menuondemand.domain.model;

import com.mavtechsa.menuondemand.domain.model.keys.Menu_R_Orden_PK;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "MENU_R_ORDEN")
@Data
public class Menu_R_Orden implements Serializable {
        private static final long serialVersionUID = 1L;

        @EmbeddedId
        private Menu_R_Orden_PK menu_r_orden_pk;

        @ManyToOne
        @JoinColumn(name = "id_menu", referencedColumnName = "id_menu", insertable = false, updatable = false)
        private Menu menu;

        @ManyToOne
        @JoinColumn(name = "id_orden", referencedColumnName = "id_orden", insertable = false, updatable = false)
        private OrdenDelDia orden;




    }
