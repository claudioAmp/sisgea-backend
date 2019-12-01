package ob.unibanca.sicf.consultasgenerales.model.rangobinvisa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.commons.spring.validation.validation.IdCadena;
import ob.commons.spring.validation.validation.group.IRegistro;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RangoBINVisa {
	  @IdCadena(minLength = 6, maxLength = 15, regexpPattern = "[0-9]+", groups = IRegistro.class)
	  String idBIN;
	  String inicioRango;
	  String finRango;
	  String digitoValidacionChequeo;
	  String longitudNumeroCuenta;
	  String tokenIndicador;
	  String reservado1;
	  String binProcesador;
	  String dominio;
	  String region;
	  String pais;
	  String largeTicket;
	  String technologyIndicator;
	  String ardefRegion;
	  String ardefPais;
	  String comercialCardLvl2DataIndicator;
	  String comercialCardLvl3EnhancedDataIndicator;
	  String comercialCardPOSPromptingIndicator;
	  String vatEvidence;
	  String originalCredit;
	  String accountLevelProcessingIndicator;
	  String originalCreditMoneyTransfer;
	  String originalCreditOnlineGambling;
	  String productID;
	  String comboCard;
	  String fastFunds;
	  String travelIndicator;
	  String r1r2r3;
	  String accountFundingSource;
	  String settlementMatch;
	  String travelAccountData;
	  String accountRestrictedUse;
	  String nnssIndicator;
	  String productSubtype;
	  String reservado2;
	  String testIndicator;
	  String reservado3;
}
