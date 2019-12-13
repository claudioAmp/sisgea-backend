package ob.unibanca.sicf.consultasgenerales.model.dcindiners;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.commons.truncadorpan.annotation.TruncarPAN;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DcinChargeDetalle {
	
	private String idDcin;
	private Integer recapNumber;
	private Integer batchNumber;
	private Integer sequenceWithinBatch;
	private String sendingInstitution;
	private String recivingInstitution;
	@TruncarPAN
	private String cardNumber;
	private Double chargeAmount;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date chargeDate;
	private String dateType;
	private String chargeType;
	private String establishmentName;
	private String establishmentCity;
	private Integer geographicAreaCode;
	private Integer actionCode;
	private String typeCharge;
	private String referenceNumber;
	private String authorizationNumber;
	private String establishmentId;
	private String issuerDiners;
	private Double chargeAmountDiners;
	private Integer internationalEstablishmentCo;
	private String establishmentStreetAddress;
	private String establishmentStateCountryPr;
	private String establishmentZipCode;
	private String establishmentPhoneNumber;
	private String merchantSpecificCode;
	private Integer merchantClasificationCode;
	private String descripcionGiroNegocio;
	private Double tax1;
	private Double tax2;
	private String originalTicket;
	private String customerReferenceNumber1;
	private String customerReferenceNumber2;
	private String customerReferenceNumber3;
	private String customerReferenceNumber4;
	private String customerReferenceNumber5;
	private String customerReferenceNumber6;
	private String cardHolderPresentIndicator;
	private String descCardHolderPresentIndicator;
	private String cardPresentIndicator;
	private String descCardPresentIndicator;
	private String cardInputDataMethod;
	private String descCardInputDataMethod;
	private String electronicCommercePaymentsI;
	private String descElectronicCommercePayments;
	private String cavv;
	private String networkReferenceId;
	private String cardDataInputCapability;
	private String descCardDataInputCapability;
	private Double surchargeFee;
	private String posTerminalTypeIndicator;
	private String acquirerGeographicAreaCode;
	private String cardType;
	private String descCardType;
	private Integer paymentToken;
	private String tokenRequestorId;
	private String tokenAssuranceLevel;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaProceso;
}
