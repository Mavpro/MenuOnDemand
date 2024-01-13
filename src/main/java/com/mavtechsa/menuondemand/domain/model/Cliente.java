package com.mavtechsa.menuondemand.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;

    private String nombreYapellido;

    private int cel;

    private String correo;

    private String direccion;

    @OneToMany(mappedBy = "cliente")
    private List<DireccionesEntrega> direccionesEntrega;

    private boolean eliminado;


}
