package ob.unibanca.sicf.consultasgenerales.model.rangobinmc;

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
public class RangoBINMC {
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date fechaProceso;
	String transactionRoutingIndicator;
	String tableId;
	String spendControlSwitch;
	String repowerReloadParticipationIndicator;
	String regulatedRateTypeIndicator;
	String region;
	String pwcbOptInSwitch;
	String psnRouteIndicator;
	Integer productTypeId;
	String productReassigmentSwitch;
	String productClass;
	String postDateServiceIndicator;
	String nonReloadablePrepaidSwitch;
	String moneysendIndicator;
	String merchantCleansingServiceParticipation;
	@DateTimeFormat(pattern = "yy/MM/dd")
	Date merchantCleansingActivationDate;
	Long memberId;
	String mealVoucherIndicator;
	String mappingServiceIndicator;
	String licenseProductId;
	String issuerTargetMarketParticipationIndicator;
	Integer issuerCardProgramIdPriorityCode;
	String issuerAccountRangeLow;
	String issuerAccountRangeHigh;
	String gcmsProductId;
	@DateTimeFormat(pattern = "yy/MM/dd")
	Date floorExpirationDate;
	String firstPresentmentReassignmentSwitch;
	String filler1;
	String filler2;
	String filler3;
	String fasterFundsIndicator;
	Long endpoint;
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
	String cardholderBillingPrimaryCurrency;
	Integer cardholderBillingCurrencyExponentDefault;
	Integer cardholderBillingCurrencyDefault;
	Integer authenticationIndicator;
	String anonymousPrepaidIndicator;
	String activeInactiveCode;
	String accountLevelManagementParticipationIndicator;
	@DateTimeFormat(pattern = "yy/MM/dd")
	Date accountLevelManagementActivationDate;
}	
