package ob.unibanca.sicf.consultasgenerales.model.incomingIATA;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IncomingIATA {
	Long idIata;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date    fechaProceso;
	Integer	codigoDebitoCredito;
	Integer sequenceNumber;
	String idBin;
	String 	numeroTarjetaCredito;
	String idMembresia;	
	String descMembresia;
	Integer idOrigen;
	String descOrigen;
	String idServicio;
	String descServicio;
	Integer idClaseTransaccion;
	Integer idCodigoTransaccion;
	Integer transaccion;
	String descTransaccion;
	String  numeroFactura;
	String	nombrePasajero;
	String codigoAutorizacion;
	Long 	montoCreditoDebito;
	String  codigoMonedaIso;	

	
}
