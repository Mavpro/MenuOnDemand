package com.mavtechsa.menuondemand.domain.model;

import com.mavtechsa.menuondemand.domain.model.enums.MenuTipo;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_menu;
    private String nombre;

    @Enumerated(EnumType.STRING)
    private MenuTipo tipoMenu;

    private boolean estado;

    private boolean eliminado;

    }





