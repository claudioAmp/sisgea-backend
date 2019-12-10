package ob.unibanca.sicf.consultasgenerales.model.incomingIATA;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IncomingIATA {
	
	Integer	codigoDebitoCredito;
	Integer	codigoAerolinea;
	Integer	numeroBoleto;
	Integer codigoIATAAgencia;
	Integer fechaEmisionBoleto;
	Integer periodoBSP;
	String	facturacionADP;
	String	nombrePasajero;
	String 	membresia;
	String 	numeroTarjetaCredito;
	String	identificadorTransaccion;
	String 	espacioReservado1;
	String 	referenciaCliente;
	Double 	montoCreditoDebito;
	Integer codigoAutorizacion;
	Integer sequenceNumber;
	Integer invoiceDate;
	String  espacioReservado2;
	String  cityName1;
	String  fareBasis1;
	String  carrier1;
	String  classService1;
	String  cityName2;
	String  fareBasis2;
	String  carrier2;
	String  classService2;
	String  cityName3;
	String  fareBasis3;
	String  carrier3;
	String  classService3;
	String  cityName4;
	String  fareBasis4;
	String  carrier4;
	String  classService4;
	String  cityName5;
	String  codigoMonedaISO;
	String  espacioReservado;
	String  destinationCity;
	String  espacioReservado3;
	String  subEntidad;
	String  numeroFactura;
	String  numeroComerciante;
	String  formaExpeditoPagos;
	String  fechaExpiracionPagos;
	Integer fechaExpiracionTarjeta;
	String  noDefinido;
	String  fechaPrimerVuelo;
	String  idOrigenArchivo;
	Integer idIATA;
	Date    fechaProceso;
	
}
