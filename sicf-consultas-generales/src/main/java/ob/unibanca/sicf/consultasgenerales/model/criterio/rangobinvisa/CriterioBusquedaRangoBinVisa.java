package ob.unibanca.sicf.consultasgenerales.model.criterio.rangobinvisa;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriterioBusquedaRangoBinVisa {
	private String idBIN;
	private String binProcesador;
	private String region;
	private List<String> pais;
	//filtro de cabeceras
	private String filtroIdBIN;
	private String filtroInicioRango;
	private String filtroFinRango;
	private String filtroDigitoValidacionChequeo;
	private String filtroLongitudNumeroCuenta;
	private String filtroTokenIndicador;
	private String filtroReservado1;
	private String filtroBinProcesador;
	private String filtroDominio;
	private String filtroRegion;
	private String filtroPais;
	private String filtroLargeTicket;
	private String filtroTechnologyIndicator;
	private String filtroArdefRegion;
	private String filtroArdefPais;
	private String filtroComercialCardLvl2DataIndicator;
	private String filtroComercialCardLvl3EnhancedDataIndicator;
	private String filtroComercialCardPOSPromptingIndicator;
	private String filtroVatEvidence;
	private String filtroOriginalCredit;
	private String filtroAccountLevelProcessingIndicator;
	private String filtroOriginalCreditMoneyTransfer;
	private String filtroOriginalCreditOnlineGambling;
	private String filtroProductID;
	private String filtroComboCard;
	private String filtroFastFunds;
	private String filtroTravelIndicator;
	private String filtroR1r2r3;
	private String filtroAccountFundingSource;
	private String filtroSettlementMatch;
	private String filtroTravelAccountData;
	private String filtroAccountRestrictedUse;
	private String filtroNnssIndicator;
	private String filtroProductSubtype;
	private String filtroReservado2;
	private String filtroTestIndicator;
	private String filtroReservado3;
	//orden de cabeceras
	private String ordenIdBIN;
	private String ordenInicioRango;
	private String ordenFinRango;
	private String ordenDigitoValidacionChequeo;
	private String ordenLongitudNumeroCuenta;
	private String ordenTokenIndicador;
	private String ordenReservado1;
	private String ordenBinProcesador;
	private String ordenDominio;
	private String ordenRegion;
	private String ordenPais;
	private String ordenLargeTicket;
	private String ordenTechnologyIndicator;
	private String ordenArdefRegion;
	private String ordenArdefPais;
	private String ordenComercialCardLvl2DataIndicator;
	private String ordenComercialCardLvl3EnhancedDataIndicator;
	private String ordenComercialCardPOSPromptingIndicator;
	private String ordenVatEvidence;
	private String ordenOriginalCredit;
	private String ordenAccountLevelProcessingIndicator;
	private String ordenOriginalCreditMoneyTransfer;
	private String ordenOriginalCreditOnlineGambling;
	private String ordenProductID;
	private String ordenComboCard;
	private String ordenFastFunds;
	private String ordenTravelIndicator;
	private String ordenR1r2r3;
	private String ordenAccountFundingSource;
	private String ordenSettlementMatch;
	private String ordenTravelAccountData;
	private String ordenAccountRestrictedUse;
	private String ordenNnssIndicator;
	private String ordenProductSubtype;
	private String ordenReservado2;
	private String ordenTestIndicator;
	private String ordenReservado3;
}
