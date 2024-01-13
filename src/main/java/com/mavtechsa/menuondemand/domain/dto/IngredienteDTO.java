package com.mavtechsa.menuondemand.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IngredienteDTO {

    private Long idIngrediente;
    private String tipo;
    private String nombre;
    private Boolean estado;
    private boolean eliminado;


}
