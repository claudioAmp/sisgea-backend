package ob.unibanca.sicf.consultasgenerales.model.criterio.observada;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriterioBusquedaObservada {
	
	String numeroTarjeta;
	List<String> idsProceso;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date fechaTransaccionInicio;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date fechaTransaccionFin;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date fechaProcesoInicio;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date fechaProcesoFin;
	List<String> origenesArchivo;
	List<Integer> indsConciliacion;
	List<String> idsMembresia;

	String secuenciaArchivo;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date fechaProceso;
	
	// Filtros
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date filtroFechaProceso;
	private String filtroNumeroTarjeta;
	private String filtroNumeroCuenta;
	private String filtroIdCanal;
	private String filtroIdProceso;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date filtroFechaTransaccion;
	private String filtroHoraTransaccion;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date filtroFechaSwitch;
	private String filtroNumeroTrace;
	private String filtroAutorizacion;
	private String filtroAuthorizationSwitch;
	private String filtroCodigoRespuesta;
	private String filtroResponseCodeSwitch;
	private String filtroMonedaTransaccion;
	private String filtroTxnCurrencySwitch;
	private String filtroIndRespuestaDiferencia;
	private String filtroIndMonedaDiferencia;
	private String filtroOrigenArchivoConciliacion;
	private String filtroIndConciliacion;
	private String filtroSecuenciaArchivo;

	// Orden
	private String ordenFechaProceso;
	private String ordenNumeroTarjeta;
	private String ordenNumeroCuenta;
	private String ordenIdCanal;
	private String ordenIdProceso;
	private String ordenFechaTransaccion;
	private String ordenHoraTransaccion;
	private String ordenFechaSwitch;
	private String ordenNumeroTrace;
	private String ordenAutorizacion;
	private String ordenAuthorizationSwitch;
	private String ordenCodigoRespuesta;
	private String ordenResponseCodeSwitch;
	private String ordenMonedaTransaccion;
	private String ordenTxnCurrencySwitch;
	private String ordenValorTransaccion;
	private String ordenTxnAmountSwitch;
	private String ordenIndRespuestaDiferencia;
	private String ordenIndMonedaDiferencia;
	private String ordenValorDiferencia;
	private String ordenOrigenArchivoConciliacion;
	private String ordenIndConciliacion;
	private String ordenSecuenciaArchivo;
	
	//Criterios de filtros de encabezado aggrid tipo RANGO
	private Double rangoValorTransaccionMin;
	private Double rangoValorTransaccionMax;
	private Double rangoTxnAmountSwitchMin;
	private Double rangoTxnAmountSwitchMax;
	private Double rangoValorDiferenciaMin;
	private Double rangoValorDiferenciaMax;
	
}