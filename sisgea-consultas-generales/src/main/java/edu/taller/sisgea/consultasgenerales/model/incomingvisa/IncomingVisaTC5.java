package edu.taller.sisgea.consultasgenerales.model.incomingvisa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class IncomingVisaTC5 {
	
	private String idSecuenciaIncoming;
	private String transactionCode;
	private String descTransactionCode;
	private String accountNumber;
	private String acquirerRefNumber;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date purchaseDate;
	private Double destinationAmount;
	private Integer destCurrencyCode;
	private String descDestCurrencyCode;
	private Double sourceAmount;
	private Integer sourceCurrencyCode;
	private String descSourceCurrencyCode;
	private String merchantName;
	private String merchantCity;
	private String merchantCountryCode;
	private String descMerchantCountryCode;
	private String merchantCategoryCode;
	private String descMerchantCategoryCode;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaProceso;
	private Integer institucionEmisora;
	private Integer institucionReceptora;
	private String descInstitucionEmisora;
	private String descInstitucionReceptora;
	private Integer idProducto;
	private String descProducto;
	private Integer idCanal;
	private String descCanal;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaIncoming;
	private String idBin;
	private String descBin;
	private String cardholderIdMethod;
	private String descCardholderIdMethod;
	private String posTerminalCapability;
	private String descPosTerminalCapability;
	private String posEntryMode;
	private String descPosEntryMode;
	private String authorizationCode;
	
	private String idMembresia;
	private String descripcionMembresia;
	private String idServicio;
	private String descripcionServicio;
	private Integer idOrigen;
	private String descripcionOrigen;
	private Integer idClaseTransaccion;
	private String descripcionClaseTransaccion;
	private Integer idCodigoTransaccion;
	private String descripcionCodigoTransaccion;
}
