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
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date fechaProcesoInicio;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date fechaProcesoFin;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date fechaProceso;
	String issuerAccountRangeLow;
	String issuerAccountRangeHigh;
	String gcmsProductId;
	//orden de cabeceras
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date filtroFechaProceso;
	String filtroTransactionRoutingIndicator;
	String filtroTableId;
	String filtroSpendControlSwitch;
	String filtroRepowerReloadParticipationIndicator;
	String filtroRegulatedRateTypeIndicator;
	String filtroRegion;
	String filtroPwcbOptInSwitch;
	String filtroPsnRouteIndicator;
	String filtroProductTypeId;
	String filtroProductReassignmentSwitch;
	String filtroProductClass;
	String filtroPostDateServiceIndicator;
	String filtroNonReloadablePrepaidSwitch;
	String filtroMoneysendIndicator;
	String filtroMerchantCleansingServiceParticipation;
	@DateTimeFormat(pattern = "yy/MM/dd")
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
	@DateTimeFormat(pattern = "yy/MM/dd")
	private Date filtroFloorExpirationDate;
	private String filtroFirstPresentmentReassignmentSwitch;
	private String filtroFiller1;
	private String filtroFiller2;
	private String filtroFiller3;
	private String filtroFasterFundsIndicator;
	private String filtroEndpoint;
	private String filtroEffectiveTimestamp;
	private String filtroDurbinRegulatedRateIndicator;
	private String filtroCountryCodeNumeric;
	private String filtroCountryCodeAlpha;
	private String filtroContactlessEnabledIndicator;
	private String filtroCoBrandParticipationSwitch;
	private String filtroChipToMagneticConversionServiceIndicator;
	private String filtroCashBackWithoutPurchaseIndicator;
	private String filtroCashAccessOnlyParticipatingIndicator;
	private String filtroCardProgramId;
	private String filtroCardholderBillingPrimaryCurrency;
	private String filtroCardholderBillingCurrencyExponentDefault;
	private String filtroCardholderBillingCurrencyDefault;
	private String filtroAuthenticationIndicator;
	private String filtroAnonymousPrepaidIndicator;
	private String filtroActiveInactiveCode;
	private String filtroAccountLevelManagementParticipationIndicator;
	@DateTimeFormat(pattern = "yy/MM/dd")
	private Date filtroAccountLevelManagementActivationDate;
	//orden de cabeceras
	private String ordenFechaProceso;
	private String ordenTransactionRoutingIndicator;
	private String ordenTableId;
	private String ordenSpendControlSwitch;
	private String ordenRepowerReloadParticipationIndicator;
	private String ordenRegulatedRateTypeIndicator;
	private String ordenRegion;
	private String ordenPwcbOptInSwitch;
	private String ordenPsnRouteIndicator;
	private String ordenProductTypeId;
	private String ordenProductReassignmentSwitch;
	private String ordenProductClass;
	private String ordenPostDateServiceIndicator;
	private String ordenNonReloadablePrepaidSwitch;
	private String ordenMoneysenIndicator;
	private String ordenMerchantCleansingServiceParticipation;
	private String ordenMerchantCleansingActivationDate;
	private String ordenMemberId;
	private String ordenMealVoucherIndicator;
	private String ordenMappingServiceIndicator;
	private String ordenLicenseProductId;
	private String ordenIssuerTargetMarketParticipationIndicator;
	private String ordenIssuerCardProgramIdPriorityCode;
	private String ordenIssuerAccountRangeLow;
	private String ordenIssuerAccountRangeHigh;
	private String ordenGcmsProductId;
	private String ordenFloorExpirationDate;
	private String ordenFirstPresentmentReassignmentSwitch;
	private String ordenFiller1;
	private String ordenFiller2;
	private String ordenFiller3;
	private String ordenFasterFundsIndicator;
	private String ordenEndpoint;
	private String ordenEffectiveTimestamp;
	private String ordenDurbinRegulatedRateIndicator;
	private String ordenCountryCodeNumeric;
	private String ordenCountryCodeAlpha;
	private String ordenContactlessEnabledIndicator;
	private String ordenCoBrandParticipationSwitch;
	private String ordenChipToMagneticConversionServiceIndicator;
	private String ordenCashBackWithoutPurchaseIndicator;
	private String ordenCashAccessOnlyParticipatingIndicator;
	private String ordenCardProgramId;
	private String ordenCardholderBillingPrimaryCurrency;
	private String ordenCardholderBillingCurrencyExponentDefault;
	private String ordenCardholderBillingCurrencyDefault;
	private String ordenAuthenticationIndicator;
	private String ordenAnonymousPrepaidIndicator;
	private String ordenActiveInactiveCode;
	private String ordenAccountLevelManagementParticipationIndicator;
	private String ordenAccountLevelManagementActivationDate;
}
