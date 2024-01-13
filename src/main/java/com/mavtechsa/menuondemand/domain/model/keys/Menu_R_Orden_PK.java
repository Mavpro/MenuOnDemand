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
public class Menu_R_Orden_PK implements Serializable {

	private static final long serialVersionUID = 953555223077836740L;

	@Column(name ="id_menu" )
	private Long id_menu;


	@Column(name ="id_orden" )
	private Long id_orden;



	private boolean estado;





}
