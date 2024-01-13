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
public class Orden_R_Cliente_PK implements Serializable {

	private static final long serialVersionUID = -1665809482837259186L;

	@Column(name ="id_cliente" )
	private Long id_cliente;


	@Column(name ="id_orden" )
	private Long id_orden;


	private boolean estado;





}
