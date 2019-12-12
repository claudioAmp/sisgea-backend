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
	String idDcin;
	String sendingInstitution;
    String receivingInstitution;
	Long cardNumber;
	Double chargeAmount;
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
	Double chargeAmountDiners;
	Integer internationalEstablishmentCo;
	String establishmentStreetAddress;
	String establishmentStateCountryPr;
	String establishmentZipCode;
	String establishmentPhoneNumber;
	String merchantSpecificCode;
	Integer merchantClasificationCode;
	Double tax1;
	Double tax2;
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
	Double surchargeFee;
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
	String descripcionMembresia;
	String idServicio;
	String descripcionServicio;
	Integer idOrigen;
	String descripcionOrigen;
	Integer idClaseTransaccion;
	String descripcionClaseTransaccion;
	Integer idCodigoTransaccion;
	String descripcionCodigoTransaccion;
	Integer idInstitucionEmisora;
	String descripcionInstitucionEmisora;
	Integer idInstitucionReceptora;
	String descripcionInstitucionReceptora;
}
