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
public class ConciliacionTablas {
	
	private Integer idConcTabla;
	@IdNumerico(maxRange = 99, groups = IRegistro.class)
	private Integer idConciliacion;
	private String nombreProcedimiento;
	@IdNumerico(maxRange = 99, groups = IRegistro.class)
	private Integer idPaquete;
	private String nombrePaquete;
	@CaracterRequerido(minLength = 2, maxLength = 2, regexpPattern = "^[0-9]{2}")
	private String idArchivoConciliarA;
	private String descripcionArchivoConciliarA;
	@CaracterRequerido(minLength = 2, maxLength = 2, regexpPattern = "^[0-9]{2}")
	private String idArchivoConciliarB;
	private String descripcionArchivoConciliarB;
	@CaracterRequerido(maxLength = 4000)
	private String tablaConciliarA;
	@CaracterRequerido(maxLength = 4000)
	private String tablaConciliarB;
	@CaracterRequerido(maxLength = 4000)
	private String filtroActualizacionA;
	@CaracterRequerido(maxLength = 4000)
	private String filtroActualizacionB;
	@IdNumerico(minRange = 0, maxRange = 9)
	private Integer aplicaExpresionA;
	@CaracterRequerido(maxLength = 4000)
	private String tablaExpresionA;
	@IdNumerico(minRange = 0, maxRange = 9)
	private Integer aplicaExpresionB;
	@CaracterRequerido(maxLength = 4000)
	private String tablaExpresionB;
	
}
