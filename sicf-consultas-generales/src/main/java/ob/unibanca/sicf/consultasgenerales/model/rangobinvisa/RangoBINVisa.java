package ob.unibanca.sicf.consultasgenerales.model.rangobinvisa;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

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
	  @DateTimeFormat(pattern = "dd/MM/yyyy")
	  Date fechaProceso;
	  String idBIN;
	  String inicioRango;
	  String finRango;
	  Integer digitoValidacionChequeo;
	  Integer longitudNumeroCuenta;
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

	  /*String idMembresia;
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
	  String descripcionInstitucionReceptora;*/
}
