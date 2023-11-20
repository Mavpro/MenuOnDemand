package com.mavtechsa.menuondemand.dominio.model;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
public class Ingredientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_ingrediente;

    private String tipo;

    private String Nombre;

    @ManyToOne
    @JoinColumn(name = "id_menu")
    private Menu menu;


    private Boolean estado;

}



