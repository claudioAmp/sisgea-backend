package ob.unibanca.sicf.consultasgenerales.model.criterio.swdmplog;

import java.util.List;

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
	
	//Filtros cabecera de grilla
	private String filtroFechaProceso;
	private String filtroIdMovTxnSwdmplog;
	private String filtroMessageType;
	private String filtroIdBin;
	private String filtroPan;
	private String filtroIdRol;
	private String filtroIdCanal;
	private String filtroProcessingCode;
	private String filtroIdProceso;
	private String filtroTransmissionDate;
	private String filtroTransmissionTime;
	private String filtroAuthorizationCode;
	private String filtroTraceNumber;
	private String filtroResponseCode;
	private String filtroTransactionCurrency;
	private String filtroTransactionAmount;
	private String filtroCardAcceptorLocation;
	private String filtroStfwdIndicator;
	private String filtroPosConditionCode;
	private String filtroMerchantType;
	private String filtroCaptureDate;
	private String filtroLocalTransactionDate;
	private String filtroLocalTransactionTime;
	private String filtroPosEntryMode;
	
	//Ordenamiento
	private String ordenFechaProceso;
	private String ordenIdMovTxnSwdmplog;
	private String ordenMessageType;
	private String ordenIdBin;
	private String ordenPan;
	private String ordenIdRol;
	private String ordenIdCanal;
	private String ordenProcessingCode;
	private String ordenIdProceso;
	private String ordenTransmissionDate;
	private String ordenTransmissionTime;
	private String ordenAuthorizationCode;
	private String ordenTraceNumber;
	private String ordenResponseCode;
	private String ordenTransactionCurrency;
	private String ordenTransactionAmount;
	private String ordenCardAcceptorLocation;
	private String ordenStfwdIndicator;
	private String ordenPosConditionCode;
	private String ordenMerchantType;
	private String ordenCaptureDate;
	private String ordenLocalTransactionDate;
	private String ordenLocalTransactionTime;
	private String ordenPosEntryMode;
	
}
