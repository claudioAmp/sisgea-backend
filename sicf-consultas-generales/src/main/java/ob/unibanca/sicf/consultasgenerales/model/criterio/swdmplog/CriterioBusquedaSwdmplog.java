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

	private String fechaInicioProceso;
	private String fechaFinProceso;
	private String fechaInicioTransaccion;
	private String fechaFinTransaccion;
	private String numeroTarjeta;//pan
	private List<Integer> idsProcesoSwitch;
	private String trace;
	private List<Integer> idsRespuestaSwitch;
	private List<Integer> idsATM;
	private List<String> idsInstitucionAdquirente;
	private List<String> idsInstitucionEmisor;
	private List<String> idsGiroNegocio;
	private String codigoAutorizacion;
	private String numeroReferencia;
	private List<String> idsModoEntradaPos;
	
	private String tipoMensaje;
	private String fechaInicioSwitch;
	private String fechaFinSwitch;
	private List<String> idsMembresia;
	private List<String> idsServicio;
	private List<Integer> idsCanal;
	private List<String> idsProceso;
	private List<Integer> idsRolTransaccion;
		
	//Detalle
	private String fechaProceso;
	private String idMovTxnSwdmplog;
}
