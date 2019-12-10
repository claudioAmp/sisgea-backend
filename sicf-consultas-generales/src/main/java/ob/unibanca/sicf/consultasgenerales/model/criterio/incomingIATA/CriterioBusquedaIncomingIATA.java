package ob.unibanca.sicf.consultasgenerales.model.criterio.incomingIATA;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriterioBusquedaIncomingIATA {
	
	//Filtros cabecera grilla
	String	filtroFacturacionADP;
	String	filtroNombrePasajero;
	String 	filtroMembresia;
	String 	filtroNumeroTarjetaCredito;
	String	filtroIdentificadorTransaccion;
	String 	filtroEspacioReservado1;
	String 	filtroReferenciaCliente;
	String  filtroFiltroEspacioReservado2;
	String  filtroCityName1;
	String  filtroFareBasis1;
	String  filtroCarrier1;
	String  filtroClassService1;
	String  filtroCityName2;
	String  filtroFareBasis2;
	String  filtroCarrier2;
	String  filtroClassService2;
	String  filtroCityName3;
	String  filtroFareBasis3;
	String  filtroCarrier3;
	String  filtroClassService3;
	String  filtroCityName4;
	String  filtroFareBasis4;
	String  filtroCarrier4;
	String  filtroClassService4;
	String  filtroCityName5;
	String  filtroCodigoMonedaISO;
	String  filtroEspacioReservado;
	String  filtroDestinationCity;
	String  filtroEspacioReservado3;
	String  filtroSubEntidad;
	String  filtroNumeroFactura;
	String  filtroNumeroComerciante;
	String  filtroFormaExpeditoPagos;
	String  filtroFechaExpiracionPagos;
	String  filtroNoDefinido;
	String  filtroFechaPrimerVuelo;
	String  filtroIdOrigenArchivo;
	Date    filtroFechaProceso;
	
	//Ordenamiento
	Integer	ordenCodigoDebitoCredito;
	Integer	ordenCodigoAerolinea;
	Integer	ordenNumeroBoleto;
	Integer ordenCodigoIATAAgencia;
	Integer ordenFechaEmisionBoleto;
	Integer ordenPeriodoBSP;
	String	ordenFacturacionADP;
	Double 	ordenMontoCreditoDebito;
	Integer ordenCodigoAutorizacion;
	Integer ordenSequenceNumber;
	Integer ordenInvoiceDate;
	String	ordenNombrePasajero;
	Integer ordenFechaExpiracionTarjeta;
	Integer ordenIdIATA;
	String 	ordenMembresia;
	String 	ordenNumeroTarjetaCredito;
	String	ordenIdentificadorTransaccion;
	String 	ordenEspacioReservado1;
	String 	ordenReferenciaCliente;
	String  ordenFiltroEspacioReservado2;
	String  ordenCityName1;
	String  ordenFareBasis1;
	String  ordenCarrier1;
	String  ordenClassService1;
	String  ordenCityName2;
	String  ordenFareBasis2;
	String  ordenCarrier2;
	String  ordenClassService2;
	String  ordenCityName3;
	String  ordenFareBasis3;
	String  ordenCarrier3;
	String  ordenClassService3;
	String  ordenCityName4;
	String  ordenFareBasis4;
	String  ordenCarrier4;
	String  ordenClassService4;
	String  ordenCityName5;
	String  ordenCodigoMonedaISO;
	String  ordenEspacioReservado;
	String  ordenDestinationCity;
	String  ordenEspacioReservado3;
	String  ordenSubEntidad;
	String  ordenNumeroFactura;
	String  ordenNumeroComerciante;
	String  ordenFormaExpeditoPagos;
	String  ordenFechaExpiracionPagos;
	String  ordenNoDefinido;
	String  ordenFechaPrimerVuelo;
	String  ordenIdOrigenArchivo;
	Date    ordenFechaProceso;
	
}
