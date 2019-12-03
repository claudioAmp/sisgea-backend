package ob.unibanca.sicf.conciliacion.model;

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
public class CampoDiferencia {
	
	private Integer idCampoDiferencia;
	@IdNumerico(maxRange = 9999, groups = IRegistro.class)
	private Integer idConcTabla;
	private String nombreProcedimiento;
	@CaracterRequerido(maxLength = 50)
	private String campoObservadoConc;
	@CaracterRequerido(maxLength = 50)
	private String campoObservadoDes;
	@IdNumerico(maxRange = 9)
	private Integer respCodeConc;
	
}
