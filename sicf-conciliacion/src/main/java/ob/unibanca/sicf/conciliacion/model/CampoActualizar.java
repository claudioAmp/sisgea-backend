package ob.unibanca.sicf.conciliacion.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.commons.spring.validation.validation.CaracterRequerido;
import ob.commons.spring.validation.validation.IdCadena;
import ob.commons.spring.validation.validation.IdNumerico;
import ob.commons.spring.validation.validation.group.IRegistro;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CampoActualizar {
	
	private Integer idCampoActualizar;
	@IdNumerico(maxRange = 9999, groups = IRegistro.class)
	private Integer idConcTabla;
	private String nombreProcedimiento;
	@IdCadena(minLength = 2, maxLength = 2, regexpPattern = "^[0-9]{2}", groups = IRegistro.class)
	private String idTablaCampoAct;
	private String descripcionTablaCampoAct;
	@IdCadena(minLength = 2, maxLength = 2, regexpPattern = "^[0-9]{2}", groups = IRegistro.class)
	private String idTablaCampoRef;
	private String descripcionTablaCampoRef;
	@CaracterRequerido(maxLength = 50)
	private String campoActualizar;
	@CaracterRequerido(maxLength = 50)
	private String campoReferencia;
	
}
