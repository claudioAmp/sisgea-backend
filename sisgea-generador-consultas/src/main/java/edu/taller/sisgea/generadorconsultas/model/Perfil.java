package edu.taller.sisgea.generadorconsultas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.commons.spring.validation.validation.CaracterRequerido;
import ob.commons.spring.validation.validation.IdNumerico;
import ob.commons.spring.validation.validation.group.IRegistro;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Perfil {
	//@IdNumerico(maxRange = 9999, groups = IRegistro.class)
	private Integer idPerfil;
	@CaracterRequerido(maxLength = 30)
	private String descripcion;
	private boolean activo;
}
