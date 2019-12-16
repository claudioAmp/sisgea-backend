package ob.unibanca.sicf.consultasgenerales.model.rangobinmc;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.unibanca.sicf.consultasgenerales.model.rangobinvisa.RangoBINVisa;
import ob.unibanca.sicf.consultasgenerales.model.rangobinvisa.RangoBINVisa.RangoBINVisaBuilder;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RangoBINMC {
	String transactionRoutingIndicator;
	String tableId;
	String spendControlSwitch;
	String repowerReloadParticipationIndicator;
	String regulatedRateTypeIndicator;
	String region;
	String pwcbOptInSwitch;
	String psnRouteIndicator;
	Integer prodcutTypeId;
	String productReassigmentSwitch;
	String productClass;
	String postDateServiceIndicator;
	String nonReloadablePrepaidSwitch;
	String moneysendIndicator;
	String merchantCleansingServiceParticipation;
	Date merchantCleansingActivationDate;
	String memberId;
	String mealVoucherIndicator;
	String mappingServiceIndicator;
	String licenseProductId;
	String issuerTargetMarketParticipationIndicator;
	Integer issuerCardProgramIdPriorityCode;
	String issuerAccountRangeLow;
	String issuerAccountRangeHigh;
	String gcmsProductId;
	String floorExpirationDate;
	String firstPresentmentReassignmentSwitch;
	String filler1;
	String filler2;
	String filler3;
	String fasterFundsIndicator;
	Integer endpoint;
	String effectiveTimestamp;
	String durbinRegulatedRateIndicator;
	Integer countryCodeNumeric;
	String countryCodeAlpha;
	String contactlessEnabledIndicator;
	String coBrandParticipationSwitch;
	String chipToMagneticConversionServiceIndicator;
	String cashBackWithoutPurchaseIndicator;
	String cashAccessOnlyParticipatingIndicator;
	String cardProgramId;
	Integer cardholderBillingPrimaryCurrency;
	Integer cardholderBillingCurrencyExponentDefault;
	Integer cardholderBillingCurrencyDefault;
	Integer authenticationIndicator;
	String anonymousPrepaidIndicator;
	String activeInactiveCode;
	String accountLevelManagementParticipationIndicator;
	String accountLevelManagementActivationDate;
	
	
}	
