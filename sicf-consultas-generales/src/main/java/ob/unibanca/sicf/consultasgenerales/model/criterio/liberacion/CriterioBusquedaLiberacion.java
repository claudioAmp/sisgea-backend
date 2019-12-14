package ob.unibanca.sicf.consultasgenerales.model.criterio.liberacion;

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
public class CriterioBusquedaLiberacion {
	
	String estadoTransaccion;
	String accountNumber;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date fechaTransaccionInicio; // transmissionDate
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date fechaTransaccionFin; // transmissionDate
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date fechaProcesoInicio; // transmissionDate
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date fechaProcesoFin; // transmissionDate
	List<Integer> idsOrigen;
	List<Integer> institucionesEmisoras;
	List<Integer> institucionesReceptoras;
	List<String> origenesArchivo;
	Integer indConciliacion;
	Integer transactionCurrency;
	
	//filtros
	private String filtroEstadoTransaccion;
	private String filtroMessageType;
	private String filtroAccountNumber;
	private String filtroTransactionCurrency;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date filtroTransmissionDate;
	private String filtroTransmissionTime;
	private String filtroTraceNumber;
	private String filtroPosConditionCode;
	private String filtroResponseCode;
	private String filtroOrigenArchivo;
	private String filtroIndConciliacion;
	private String filtroProcessingCode;
	private String filtroReferenceNumber;
	private String filtroAccountIdentification1;
	private String filtroAccountIdentification2;
	private String filtroAuthorizationCode;
	private String filtroIdInstitucionEmisora;
	private String filtroIdInstitucionReceptora;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date filtroCaptureDate;
	private String filtroIdMembresia;
	private String filtroIdOrigen;
	private String filtroIdProceso;
	private String filtroIdProducto;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date filtroFechaRegistro;
	private String filtroHoraRegistro;
	private String filtroSecuenciaSwdmplog;
	
	//Orden
	private String ordenEstadoTransaccion;
	private String ordenMessageType;
	private String ordenAccountNumber;
	private String ordenTransactionAmount;
	private String ordenTransactionCurrency;
	private String ordenSettlementAmount;
	private String ordenTransmissionDate;
	private String ordenTransmissionTime;
	private String ordenTraceNumber;
	private String ordenPosConditionCode;
	private String ordenResponseCode;
	private String ordenOrigenArchivo;
	private String ordenIndConciliacion;
	private String ordenProcessingCode;
	private String ordenReferenceNumber;
	private String ordenAccountIdentification1;
	private String ordenAccountIdentification2;
	private String ordenAuthorizationCode;
	private String ordenIdInstitucionEmisora;
	private String ordenIdInstitucionReceptora;
	private String ordenCaptureDate;
	private String ordenIdMembresia;
	private String ordenIdOrigen;
	private String ordenIdProceso;
	private String ordenIdProducto;
	private String ordenFechaRegistro;
	private String ordenHoraRegistro;
	private String ordenSecuenciaSwdmplog;
	
	//Criterios de filtros de encabezado aggrid tipo RANGO
	private Double rangoTransactionAmountMin;
	private Double rangoTransactionAmountMax;
	private Double rangoSettlementAmountMin;
	private Double rangoSettlementAmountMax;
	
}