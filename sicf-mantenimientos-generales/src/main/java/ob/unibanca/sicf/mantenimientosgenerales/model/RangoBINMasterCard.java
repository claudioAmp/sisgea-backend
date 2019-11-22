package ob.unibanca.sicf.mantenimientosgenerales.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RangoBINMasterCard {
			  String effectiveTimestamp ;
			  String activeInactiveCode ;
			  String tableId ;
			  String issuerAccountRangeLow ;
			  String gcmsProductId ;
			  String issuerAccountRangeHigh ;
			  String cardProgramId ;
			  Integer issuerCardProgramIdPriorityCode ;
			  Integer memberId ;
			  Integer productTypeId ;
			  Integer endpoint ;
			  String countryCodeAlpha ;
			  Integer countryCodeNumeric ;
			  String region ;
			  String productClass ;
			  String transactionRoutingIndicator ;
			  String firstPresentmentReassignmentSwitch ;
			  String productReassignmentSwitch ;
			  String pwcbOptInSwitch ;
			  String licenseProductId ;
			  String mappingServiceIndicator ;
			  String accountLevelManagementParticipationIndicator ;
			  String accountLevelManagementActivationDate ;
			  String cardholderBillingCurrencyDefault ;
			  String cardholderBillingCurrencyExponentDefault ;
			  String cardholderBillingPrimeryCurrency ;
			  String chipToMagneticConversionServiceIndicator ;
			  String floorExpirationDate ;
			  String coBrandParticipationSwitch ;
			  String spendControlSwitch ;
			  String merchantCleansingServiceParticipation ;
			  String merchantCleansingActivationDate ;
			  String contaclessEnabledIndicator ;
			  String regulatedRateTypeIndicator ;
			  String psnRouteIndicator ;
			  String cashBackWithoutPurchaseIndicator ;
			  String filler1 ;
			  String repowerReloadParticipatingIndicator ;
			  String moneysendIndicator ;
			  String durbinRegulatedRateIndicator ;
			  String cashAccessOnlyParticipatingIndicator ;
			  Integer authenticationIndicator ;
			  String filler2 ;
			  String issuerTargetMarketParticipationIndicator ;
			  String postDateServiceIndicator ;
			  String mealVoucherIndicator ;
			  String nonReloadablePrepaidSwitch ;
			  String fasterFundsIndicator ;
			  String anonymousPrepaidIndicator ;
			  String filler3 ;
}
