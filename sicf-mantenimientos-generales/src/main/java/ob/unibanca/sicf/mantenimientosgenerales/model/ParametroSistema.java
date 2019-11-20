package ob.unibanca.sicf.mantenimientosgenerales.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.commons.spring.validation.validation.CaracterRequerido;
import ob.commons.spring.validation.validation.IdNumerico;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParametroSistema {
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaProceso;
	@IdNumerico(maxRange = 99999)
	private Integer idInstitucion;
	private String descripcionInstitucion;
	@IdNumerico(maxRange = 999)
	private Integer idMonedaProcesador;
	private String descripcionMonedaProcesador;
	private double porcentajeIGV;
	private double porcentajeRenta;
	private double porcentajeDetraccion;
	private double limiteDetraccion;
	@CaracterRequerido(maxLength = 20, regexpPattern = "[0-9]+")
	private String cuentaDetraccion;
}
