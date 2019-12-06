package ob.unibanca.sicf.consultasgenerales.model.criterio.dcindiners;

import java.util.Date;

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
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date recapDateInicio;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date recapDateFin;
	private Long idDcin;
	private String sendingInstitution;
	private String receivingInstitution;
	private Long cardNumber;
	private String chargeType;
	private String establishmentName;
	private String establishmentCity;
	private String authorizationNumber;
	private Integer merchantClasificationCode;
	private String cardHolderPresentIndicator;
	private String cardPresentIndicator;
	private String cardInputDataMethod;
	private String electronicCommercePaymentsI;
	private String cardDataInputCapability;
	private String cardType;
	//Filtros de cabeceras
	private String filtroIdDcin;
	private String filtroSendingInstitution;
    private String filtroReceivingInstitution;
	private String filtroCardNumber;
	private String filtroChargeAmount;
	private String filtroChargeDate;
	private String filtroDateType;
	private String filtroChargeType;
	private String filtroEstablishmentName;
	private String filtroEstablishmentCity;
	private String filtroActionCode;
	private String filtroTypeCharge;
	private String filtroReferenceNumber;
	private String filtroAuthorizationNumber;
	private String filtroIssuerDiners;
	private String filtroChargeAmountDiners;
	private String filtroMerchantClasificationCode;
	private String filtroTax1;
	private String filtroTax2;
	private String filtroOriginalTicket;
	private String filtroCardHolderPresentIndicator;
	private String filtroCardPresentIndicator;
	private String filtroCardInputDataMethod;
	private String filtroElectronicCommercePaymentsI;
	private String filtroCavv;
	private String filtroCardDataInputCapability;
	private String filtroSurchargeFee;
	private String filtroPosTerminalTypeIndicator;
	private String filtroCardType;
	private String filtroFechaProceso;
	private String filtroRecapDate;
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
	private String ordenActionCode;
	private String ordenTypeCharge;
	private String ordenReferenceNumber;
	private String ordenAuthorizationNumber;
	private String ordenIssuerDiners;
	private String ordenChargeAmountDiners;
	private String ordenMerchantClasificationCode;
	private String ordenTax1;
	private String ordenTax2;
	private String ordenOriginalTicket;
	private String ordenCardHolderPresentIndicator;
	private String ordenCardPresentIndicator;
	private String ordenCardInputDataMethod;
	private String ordenElectronicCommercePaymentsI;
	private String ordenCavv;
	private String ordenCardDataInputCapability;
	private String ordenSurchargeFee;
	private String ordenPosTerminalTypeIndicator;
	private String ordenCardType;
	private String ordenFechaProceso;
	private String ordenRecapDate;
}
