package ob.unibanca.sicf.consultasgenerales.model.dcindiners;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DcinCharge {
	Long idDcin;
	String sendingInstitution;
    String receivingInstitution;
	Long cardNumber;
	double chargeAmount;
	Date chargeDate;
	String dateType;
	String chargeType;
	String establishmentName;
	String establishmentCity;
	Integer geographicAreaCode;
	Integer actionCode;
	String typeCharge;
	String referenceNumber;
	String authorizationNumber;
	String establishmentId;
	String issuerDiners;
	double chargeAmountDiners;
	Integer internationalEstablishmentCo;
	String establishmentStreetAddress;
	String establishmentStateCountryPr;
	String establishmentZipCode;
	String establishmentPhoneNumber;
	String merchantSpecificCode;
	Integer merchantClasificationCode;
	double tax1;
	double tax2;
	String originalTicket;
	String customerReferenceNumber1;
	String customerReferenceNumber2;
	String customerReferenceNumber3;
	String customerReferenceNumber4;
	String customerReferenceNumber5;
	String customerReferenceNumber6;
	String cardHolderPresentIndicator;
	String cardPresentIndicator;
	String cardInputDataMethod;
	String electronicCommercePaymentsI;
	String cavv;
	String networkReferenceId;
	String cardDataInputCapability;
	double surchargeFee;
	String posTerminalTypeIndicator;
	String acquirerGeographicAreaCode;
	String cardType;
	Long paymentToken;
	String tokenRequestorId;
	String tokenAssuranceLevel;
	Date fechaProceso;
	String idOrigenArchivo;
	Date recapDate;

	String idMembresia;
	String descMembresia;
	String idServicio;
	String descServicio;
	Integer idOrigen;
	String descOrigen;
	Integer idClaseTransaccion;
	String desClaseTransaccion;
	Integer idCodigoTransaccion;
	String descCodigoTransaccion;
	Integer idInstitucionEmisora;
	String descInstitucionEmisora;
	Integer idInstitucionReceptora;
	String descInstitucionReceptora;
}
