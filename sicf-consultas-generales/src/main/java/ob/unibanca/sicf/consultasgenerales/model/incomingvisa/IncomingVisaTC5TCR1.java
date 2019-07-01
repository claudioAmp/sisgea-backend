package ob.unibanca.sicf.consultasgenerales.model.incomingvisa;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IncomingVisaTC5TCR1 {
	private Integer idSecuenciaIncoming;
	private String transactionCode;
	private String descTransactionCode;
	private String transCodeQualifier;
	private String descTransCodeQualifier;
	private Integer chargebackRefNumber;
	private String documentationIndicator;
	private String memberMessageText;
	private String specialConditionInd;
	private String feeProgramIndicator;
	private String descFeeProgramIndicator;
	private String issuerCharge;
	private String descIssuerCharge;
	private String cardAcceptorId;
	private String terminalId;
	private Integer nationalReimbursementFee;
	private String mailPhoneEcommerceInd;
	private String specialChargebackInd;
	private String interfaceTraceNumber;
	private String acceptanceTerminalInd;
	private String prepaidCardInd;
	private String descPrepaidCardInd;
	private String serviceDevelopmentField;
	private String descServiceDevelopment;
	private String avsResponseCode;
	private String descAvsResponseCode;
	private String authorizationSourceCode;
	private String purchaseIdentifierFormat;
	private String accountSelection;
	private String installmentPaymentCount;
	private String purchaseIdentifier;
	private Integer cashback;
	private String chipConditionCode;
	private String posEnvironment;
	private String descPosEnvironment;
	private Date fechaProceso;
	private Integer numeroCuota;
}
