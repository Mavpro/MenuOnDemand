package com.mavtechsa.menuondemand.domain.model;

import com.mavtechsa.menuondemand.domain.model.keys.Menu_R_Ingrediente_PK;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "MENU_R_INGREDIENTE")
@Data
public class Menu_R_Ingrediente implements Serializable {
        private static final long serialVersionUID = 1L;

        @EmbeddedId
        private Menu_R_Ingrediente_PK menu_r_ingrediente_pk;

        @ManyToOne
        @JoinColumn(name = "id_menu", referencedColumnName = "id_menu", insertable = false, updatable = false)
        private Menu menu;

        @ManyToOne
        @JoinColumn(name = "id_ingrediente", referencedColumnName = "id_ingrediente", insertable = false, updatable = false)
        private Ingrediente ingrediente;

        private boolean eliminado;


    }
