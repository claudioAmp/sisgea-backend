package ob.unibanca.sicf.consultasgenerales.model.criterio.dcindiners;

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
public class CriterioBusquedaDcinCharge {
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date chargeDateInicio;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date chargeDateFin;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaProcesoInicio;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaProcesoFin;
	private String cardNumber;
	private String cardPresentIndicator;
	private String cardType;
	private String authorizationNumber;
	private List<String> merchantClasificationCode;
	
	//Detalle
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaProceso;
	private String idDcin;
	
	//Filtros de cabeceras
	private String filtroIdDcin;
	private String filtroSendingInstitution;
    private String filtroReceivingInstitution;
	private String filtroCardNumber;
	//private String filtroChargeAmount;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date filtroChargeDate;
	private String filtroDateType;
	private String filtroChargeType;
	private String filtroEstablishmentName;
	private String filtroEstablishmentCity;
	private String filtroGeographicAreaCode;
	private String filtroActionCode;
	private String filtroTypeCharge;
	private String filtroReferenceNumber;
	private String filtroAuthorizationNumber;
	private String filtroMerchantClasificationCode;
	private String filtroCardHolderPresentIndicator;
	private String filtroCardPresentIndicator;
	private String filtroCardInputDataMethod;
	private String filtroCardDataInputCapability;
	private String filtroAcquirerGeographicAreaCode;
	private String filtroCardType;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date filtroFechaProceso;
	private String filtroIdOrigenArchivo;
	private String filtroIdMembresia;
	private String filtroIdServicio;
	private String filtroIdOrigen;
	private String filtroIdClaseTransaccion;
	private String filtroIdCodigoTransaccion;
	private String filtroIdInstitucionEmisora;
	private String filtroIdInstitucionReceptora;
	
	//orden de cabeceras
	private String ordenIdDcin;
	private String ordenSendingInstitution;
    private String ordenReceivingInstitution;
	private String ordenCardNumber;
	private String ordenChargeAmount;
	private String ordenChargeDate;
	private String ordenDateType;
	private String ordenChargeType;
	private String ordenEstablishmentName;
	private String ordenEstablishmentCity;
	private String ordenGeographicAreaCode;
	private String ordenActionCode;
	private String ordenTypeCharge;
	private String ordenReferenceNumber;
	private String ordenAuthorizationNumber;
	private String ordenMerchantClasificationCode;
	private String ordenCardHolderPresentIndicator;
	private String ordenCardPresentIndicator;
	private String ordenCardInputDataMethod;
	private String ordenCardDataInputCapability;
	private String ordenAcquirerGeographicAreaCode;
	private String ordenCardType;
	private String ordenFechaProceso;
	private String ordenIdOrigenArchivo;
	private String ordenIdMembresia;
	private String ordenIdServicio;
	private String ordenIdOrigen;
	private String ordenIdClaseTransaccion;
	private String ordenIdCodigoTransaccion;
	private String ordenIdInstitucionEmisora;
	private String ordenIdInstitucionReceptora;
	
	//Criterios de filtros de encabezado aggrid tipo RANGO
	private Double rangoChargeAmountMin;
	private Double rangoChargeAmountMax;
}
