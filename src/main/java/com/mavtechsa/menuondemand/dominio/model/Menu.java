package com.mavtechsa.menuondemand.dominio.model;

import com.mavtechsa.menuondemand.dominio.model.enums.MenuTipo;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_menu;
    private String nombre;

    @Enumerated(EnumType.STRING)
    private MenuTipo tipoMenu;

    @OneToMany(mappedBy = "menu")
    private List<Ingredientes> ingredientes;

    @ManyToOne
    @JoinColumn(name = "id_orden")
    private OrdenDelDia orden;

    private boolean estado;


    }





