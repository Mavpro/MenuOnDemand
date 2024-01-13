package com.mavtechsa.menuondemand.domain.model;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
public class Ingrediente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_ingrediente;

    private String tipo;

    private String Nombre;

    private Boolean estado;

    private boolean eliminado;

}



