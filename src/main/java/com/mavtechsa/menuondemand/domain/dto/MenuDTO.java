package com.mavtechsa.menuondemand.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuDTO {

    private long idMenu;
    private String nombre;
    private String tipoMenu;
    private boolean estado;
    private boolean eliminado;


}