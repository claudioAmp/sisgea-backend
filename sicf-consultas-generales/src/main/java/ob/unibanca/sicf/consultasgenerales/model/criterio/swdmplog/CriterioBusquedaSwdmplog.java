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
	
	//Filtros de busqueda
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaInicioProceso;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaFinProceso;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaInicioTransaccion;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaFinTransaccion;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaInicioSwitch;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaFinSwitch;
	private List<Integer> idsProcesoSwitch;
	private String tipoMensaje;
	private String trace;
	private List<String> idsMembresia;
	private List<String> idsServicio;
	private List<Integer> idsCanal;
	private List<Integer> institucionesEmisoras;
	private List<String> idsBines;
	private List<Integer> institucionesReceptoras;
	private List<Integer> idsRespuestaSwitch;
	private String numeroTarjeta;//pan
		
	//Detalle
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaProceso;
	private String idMovTxnSwdmplog;
	
	//Filtros cabecera de grilla
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date filtroFechaProceso;
	private String filtroIdBin;
	private String filtroPan;
	private String filtroMessageType;
	private String filtroIdProceso;
	private String filtroIdCanal;
	private String filtroCardAcceptorLocation;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date filtroTransmissionDate;
	private String filtroTransmissionTime;
	private String filtroTransactionCurrency;
	private String filtroTransactionAmount;
	private String filtroTraceNumber;
	private String filtroAuthorizationCode;
	private String filtroResponseCode;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date filtroLocalTransactionDate;
	private String filtroLocalTransactionTime;
	private String filtroIdMembresia;
	private String filtroIdServicio;
	private String filtroIdInstitucionEmisora;
	private String filtroIdInstitucionReceptora;
	private String filtroPosEntryMode;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date filtroCaptureDate;
	private String filtroIdMovTxnSwdmplog;
	
	//Ordenamiento
	private String ordenFechaProceso;
	private String ordenIdBin;
	private String ordenPan;
	private String ordenMessageType;
	private String ordenIdProceso;
	private String ordenIdCanal;
	private String ordenCardAcceptorLocation;
	private String ordenTransmissionDate;
	private String ordenTransmissionTime;
	private String ordenTransactionCurrency;
	private String ordenTransactionAmount;
	private String ordenTraceNumber;
	private String ordenAuthorizationCode;
	private String ordenResponseCode;
	private String ordenLocalTransactionDate;
	private String ordenLocalTransactionTime;
	private String ordenIdMembresia;
	private String ordenIdServicio;
	private String ordenIdInstitucionEmisora;
	private String ordenIdInstitucionReceptora;
	private String ordenPosEntryMode;
	private String ordenCaptureDate;
	private String ordenIdMovTxnSwdmplog;
	
	//Criterios de filtros de encabezado aggrid tipo RANGO
	private Double rangoTransactionAmountMin;
	private Double rangoTransactionAmountMax;
}
