package com.mavtechsa.menuondemand.mapper;


import com.mavtechsa.menuondemand.domain.dto.IngredienteDTO;
import com.mavtechsa.menuondemand.domain.model.Ingrediente;
import org.mapstruct.Mapper;

@Mapper
public interface IngredienteMapper {

    Ingrediente toIngrediente(IngredienteDTO ingredienteDTO);

    IngredienteDTO toIngredienteDTO(Ingrediente ingrediente);

}