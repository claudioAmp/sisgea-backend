package edu.taller.sisgea.consultasgenerales.model.dcioutdiners;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.commons.truncadorpan.annotation.TruncarPAN;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DcioutCharge {
	
	private String idDciout;
	private String sendingInstitution;
	private String receivingInstitution;
	@TruncarPAN
	private String cardNumber;
	private Double chargeAmount;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date chargeDate;
	private String dateType;
	private String chargeType;
	private String establishmentName;
	private String establishmentCity;
	private Integer geographicAreaCode;
	private Integer actionCode;
	private String typeCharge;
	private String referenceNumber;
	private String authorizationNumber;
	private Integer merchantClasificationCode;
	private String descripcionGiroNegocio;
	private String cardHolderPresentIndicator;
	private String descCardHolderPresentIndicator;
	private String cardPresentIndicator;
	private String descCardPresentIndicator;
	private String cardInputDataMethod;
	private String descCardInputDataMethod;
	private String cardDataInputCapability;
	private String descCardDataInputCapability;
	private String acquirerGeographicAreaCode;
	private String cardType;
	private String descCardType;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaProceso;
	private String idOrigenArchivo;
	private String descripcionOrigenArchivo;
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
	private Integer idInstitucionEmisora;
	private String descripcionInstitucionEmisora;
	private Integer idInstitucionReceptora;
	private String descripcionInstitucionReceptora;
	
}
