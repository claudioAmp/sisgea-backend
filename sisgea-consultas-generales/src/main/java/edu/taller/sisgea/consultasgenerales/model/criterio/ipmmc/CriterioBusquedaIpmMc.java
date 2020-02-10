package edu.taller.sisgea.consultasgenerales.model.criterio.ipmmc;

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
public class CriterioBusquedaIpmMc {
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date fechaProcesoInicio;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date fechaProcesoFin;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date dateLocalTxnInicio;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date dateLocalTxnFin;
	String pan;
	List<String> typeRecord;
	List<String> cardDataInputCapability;
	List<String> cardDataInputMode;
	List<String> cardhAuthenticationMethod;
	Integer currencyCodeCardholder;
	List<Integer> idCanal;
	List<Integer> idInstitucionEmisora;
	List<String> idProceso;
	List<String> idBin;
	
	//Filtro para Llamar Detalle del IPM
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date dateLocalTxn;
	String tramsKey;
	
	//filtros Grilla
	private String filtroTramsKey;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date filtroFechaProceso;
	private String filtroPan;
	private String filtroTypeRecord;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date filtroDateLocalTxn;
	private String filtroTimeLocalTxn;
	private String filtroCardDataInputCapability;
	private String filtroCardDataInputMode;
	private String filtroCardhAuthenticationMethod;
	private String filtroCardAcceptorBusinessCode;
	private String filtroAcquirerReferenceData;
	private String filtroApprovalCode;
	private String filtroCardAcceptorName;
	private String filtroCardAcceptorCountrycode;
	private String filtroCurrencyCodeTransaction;
	private String filtroCurrencyCodeCardholder;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date filtroSettlDate;
	private String filtroIdTransaccion;
	private String filtroIdProducto;
	private String filtroIdCanal;
	private String filtroIdInstitucionEmisora;
	private String filtroIdInstitucionReceptora;
	private String filtroIdProceso;
	private String filtroIdBin;
	private String filtroIdMembresia;
	private String filtroIdServicio;
	private String filtroIdOrigen;
	
	//orden Grilla
	private String ordenTramsKey;
	private String ordenFechaProceso;
	private String ordenPan;
	private String ordenTypeRecord;
	private String ordenAmountTxn;
	private String ordenAmountCardholder;
	private String ordenDateLocalTxn;
	private String ordenTimeLocalTxn;
	private String ordenCardDataInputCapability;
	private String ordenCardDataInputMode;
	private String ordenCardhAuthenticationMethod;
	private String ordenCardAcceptorBusinessCode;
	private String ordenAcquirerReferenceData;
	private String ordenApprovalCode;
	private String ordenCardAcceptorName;
	private String ordenCardAcceptorCountrycode;
	private String ordenCurrencyCodeTransaction;
	private String ordenCurrencyCodeCardholder;
	private String ordenSettlDate;
	private String ordenIdTransaccion;
	private String ordenIdProducto;
	private String ordenIdCanal;
	private String ordenIdInstitucionEmisora;
	private String ordenIdInstitucionReceptora;
	private String ordenIdProceso;
	private String ordenIdBin;
	private String ordenIdMembresia;
	private String ordenIdServicio;
	private String ordenIdOrigen;
	
	//Criterios de filtros de encabezado aggrid tipo RANGO
	private Double rangoAmountTxnMin;
	private Double rangoAmountTxnMax;
	private Double rangoAmountCardholderMin;
	private Double rangoAmountCardholderMax;
	
}