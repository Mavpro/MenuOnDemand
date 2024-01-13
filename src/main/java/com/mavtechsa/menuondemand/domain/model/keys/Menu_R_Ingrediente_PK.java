package com.mavtechsa.menuondemand.domain.model.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Menu_R_Ingrediente_PK implements Serializable {

	private static final long serialVersionUID = 926466303077836740L;

	@Column(name ="id_menu" )
	private Long id_menu;


	@Column(name ="id_ingrediente" )
	private Long id_ingrediente;


	private boolean estado;





}
