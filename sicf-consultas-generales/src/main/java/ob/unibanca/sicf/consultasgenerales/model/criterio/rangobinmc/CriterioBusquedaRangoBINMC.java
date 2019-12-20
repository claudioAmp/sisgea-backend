package ob.unibanca.sicf.consultasgenerales.model.criterio.rangobinmc;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

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
public class CriterioBusquedaRangoBINMC {
	String issuerAccountRangeLow;
	String issuerAccountRangeHigh;
	String gcmsProductId;
	//orden de cabeceras
	String filtroTransactionRoutingIndicator;
	String filtroTableId;
	String filtroSpendControlSwitch;
	String filtroRepowerReloadParticipationIndicator;
	String filtroRegulatedRateTypeIndicator;
	String filtroRegion;
	String filtroPwcbOptInSwitch;
	String filtroPsnRouteIndicator;
	String filtroProdcutTypeId;
	String filtroProductReassigmentSwitch;
	String filtroProductClass;
	String filtroPostDateServiceIndicator;
	String filtroNonReloadablePrepaidSwitch;
	String filtroMoneysendIndicator;
	String filtroMerchantCleansingServiceParticipation;
	@DateTimeFormat(pattern = "yy/mm/dd")
	Date filtroMerchantCleansingActivationDate;
	String filtroMemberId;
	String filtroMealVoucherIndicator;
	String filtroMappingServiceIndicator;
	String filtroLicenseProductId;
	String filtroIssuerTargetMarketParticipationIndicator;
	String filtroIssuerCardProgramIdPriorityCode;
	String filtroIssuerAccountRangeLow;
	String filtroIssuerAccountRangeHigh;
	String filtroGcmsProductId;
	String filtroFloorExpirationDate;
	String filtroFirstPresentmentReassignmentSwitch;
	String filtroFiller1;
	String filtroFiller2;
	String filtroFiller3;
	String filtroFasterFundsIndicator;
	String filtroEndpoint;
	String filtroEffectiveTimestamp;
	String filtroDurbinRegulatedRateIndicator;
	String filtroCountryCodeNumeric;
	String filtroCountryCodeAlpha;
	String filtroContactlessEnabledIndicator;
	String filtroCoBrandParticipationSwitch;
	String filtroChipToMagneticConversionServiceIndicator;
	String filtroCashBackWithoutPurchaseIndicator;
	String filtroCashAccessOnlyParticipatingIndicator;
	String filtroCardProgramId;
	String filtroCardholderBillingPrimaryCurrency;
	String filtroCardholderBillingCurrencyExponentDefault;
	String filtroCardholderBillingCurrencyDefault;
	String filtroAuthenticationIndicator;
	String filtroAnonymousPrepaidIndicator;
	String filtroActiveInactiveCode;
	String filtroAccountLevelManagementParticipationIndicator;
	String filtroAccountLevelManagementActivationDate;
	//orden de cabeceras
	String ordenTransactionRoutingIndicator;
	String ordenTableId;
	String ordenSpendControlSwitch;
	String ordenRepowerReloadParticipationIndicator;
	String ordenRegulatedRateTypeIndicator;
	String ordenRegion;
	String ordenPwcbOptInSwitch;
	String ordenPsnRouteIndicator;
	String ordenProdcutTypeId;
	String ordenProductReassigmentSwitch;
	String ordenProductClass;
	String ordenPostDateServiceIndicator;
	String ordenNonReloadablePrepaidSwitch;
	String ordenMoneysenIndicator;
	String ordenMerchantCleansingServiceParticipation;
	String ordenMerchantCleansingActivationDate;
	String ordenMemberId;
	String ordenMealVoucherIndicator;
	String ordenMappingServiceIndicator;
	String ordenLicenseProductId;
	String ordenIssuerTargetMarketParticipationIndicator;
	String ordenIssuerCardProgramIdPriorityCode;
	String ordenIssuerAccountRangeLow;
	String ordenIssuerAccountRangeHigh;
	String ordenGcmsProductId;
	String ordenFloorExpirationDate;
	String ordenFirstPresentmentReassignmentSwitch;
	String ordenFiller1;
	String ordenFiller2;
	String ordenFiller3;
	String ordenFasterFundsIndicator;
	String ordenEndpoint;
	String ordenEffectiveTimestamp;
	String ordenDurbinRegulatedRateIndicator;
	String ordenCountryCodeNumeric;
	String ordenCountryCodeAlpha;
	String ordenContactlessEnabledIndicator;
	String ordenCoBrandParticipationSwitch;
	String ordenChipToMagneticConversionServiceIndicator;
	String ordenCashBackWithoutPurchaseIndicator;
	String ordenCashAccessOnlyParticipatingIndicator;
	String ordenCardProgramId;
	String ordenCardholderBillingPrimaryCurrency;
	String ordenCardholderBillingCurrencyExponentDefault;
	String ordenCardholderBillingCurrencyDefault;
	String ordenAuthenticationIndicator;
	String ordenAnonymousPrepaidIndicator;
	String ordenActiveInactiveCode;
	String ordenAccountLevelManagementParticipationIndicator;
	String ordenAccountLevelManagementActivationDate;
}
