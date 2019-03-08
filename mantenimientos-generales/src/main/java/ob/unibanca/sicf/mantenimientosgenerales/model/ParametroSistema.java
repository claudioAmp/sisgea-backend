package ob.unibanca.sicf.mantenimientosgenerales.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.commons.validation.validation.CaracterRequerido;
import ob.commons.validation.validation.IdNumerico;
import ob.commons.validation.validation.group.IRegistro;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParametroSistema {
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaProceso;
	@IdNumerico(maxRange = 99999, groups = IRegistro.class)
	private int idInstitucion;
	private String descripcionInstitucion;
	@IdNumerico(maxRange = 999, groups = IRegistro.class)
	private int idMonedaProcesador;
	private String descripcionMonedaProcesador;
	private double porcentajeIGV;
	private double porcentajeRenta;
	private double porcentajeDetraccion;
	private double limiteDetraccion;
	@CaracterRequerido(maxLength = 20, regexpPattern="[0-9]+")
	private String cuentaDetraccion;
	
}
