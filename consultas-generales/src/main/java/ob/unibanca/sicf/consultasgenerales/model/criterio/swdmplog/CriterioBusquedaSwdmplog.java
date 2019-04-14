package ob.unibanca.sicf.consultasgenerales.model.criterio.swdmplog;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ob.unibanca.sicf.consultasgenerales.model.criterio.paginacion.CriterioPaginacion2;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CriterioBusquedaSwdmplog extends CriterioPaginacion2 {
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaInicioProceso;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaFinProceso;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaInicioTransaccion;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaFinTransaccion;
	private String numeroTarjeta;
	private List<Integer> idsProcesoSwitch;
	private String trace;
	private List<Integer> idsRespuestaSwitch;
	private List<String> idsGiroNegocio;
	private List<String> idsInstitucionEmisor;
	private List<String> idsInstitucionAdquirente;
}
