package ob.unibanca.sicf.consultasgenerales.model.compensacion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ob.commons.truncadorpan.annotation.TruncarPAN;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Compensacion {
	
	long idSecuencia;
	String idMembresia;
	String descMembresia;
	String idServicio;
	String descServicio;
	Integer idOrigen;
	String descOrigen;
	Integer idTransaccion;
	String descCodigoTransaccion;
	Integer idCanal;
	String descCanal;
	Integer idInstitucionEmisora;
	String descInstitucionEmisora;
	Integer idInstitucionReceptora;
	String descInstitucionReceptora;
	@TruncarPAN
	String numeroTarjeta;
	String bin;
	String descBin;
	Integer idMonedaCompensacion;
	String descMonedaCompensacion;
	double valorCompensacion;
	Date fechaTransaccion;
	Date fechaProceso;
	Date fechaSwitch;
	String codigoRespuesta;
	String descCodigoRespuesta;
	String numeroTrace;
	String giroNegocio;
	String descGiroNegocio;
	String nombreAdquirente;
	String ciudadAdquirente;
	String paisAdquirente;
	String descPaisAdquirente;
	String horaTransaccion;
	String codigoAutorizacion;
}
