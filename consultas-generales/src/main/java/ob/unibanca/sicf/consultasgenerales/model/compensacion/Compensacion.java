package ob.unibanca.sicf.consultasgenerales.model.compensacion;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Compensacion {
	Integer idSecuencia;
	String idMembresia;
	String descMembresia;
	String idServicio;
	String descServicio;
	Integer idOrigen;
	String descOrigen;
	Integer idClaseTransaccion;
	String descClaseTransaccion;
	Integer idCodigoTransaccion;
	String descCodigoTransaccion;
	Integer idRol;
	String descRol;
	Integer idCanal;
	String descCanal;
	Integer idInstitucionEmisora;
	String descInstitucionEmisora;
	Integer idInstitucionReceptora;
	String descInstitucionReceptora;
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
	String horaTransaccion;
}
