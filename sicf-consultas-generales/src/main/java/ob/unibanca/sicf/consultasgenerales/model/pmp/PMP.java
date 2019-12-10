package ob.unibanca.sicf.consultasgenerales.model.pmp;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ob.unibanca.sicf.consultasgenerales.model.binvisa.BINVisa;
import ob.unibanca.sicf.consultasgenerales.model.binvisa.BINVisa.BINVisaBuilder;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PMP {
	//Campos filtros de consulta
	Integer idMovIncomingPMP;
    Integer idCodigoTransaccionPMP;
    Integer idProductoPMP;
    Date fechaIncoming;
    String binAdquirente;
    String idTrace;
    String numeroTarjeta;
    String nombreEstablecimiento;
    String nombreCiudad;
    String idCategoriaNegocio;
    Date fechaProceso;
    ////////////////////
    String idOrigenArchivo;
    Integer origen;
    Integer idMoneda;
    Double tipoCambio;
    String medioTransaccion;
    Date fechaTransaccion;
    String codigoEstablecimiento;
    String codigoAutorizacion;
    Double valorTransaccion;
    Double valorComision;
    String idPais;
    String idBancoReceptor;
    String idAgenciaPagador;
    String terminal;
    String lote;
    String loteReferencia;
    String ubicacionPos;
    String icaEmisor;
    Double valorComisionEmisor;
    Double valorTransaccionDolares;
    Double valorComisionDolares;
    Double valorComisionEmisorDolares;
    String tipoDevolucion;
    String codigoAutorizacionDevolucion;
    String pctComisionEstablecimiento;
    String codigoCuota;
    String fechaCuota;
    String valorCuota;
    String idItem;
    String idArn; 
    Double tipoCambioDolares;
    String tasaIntercambio;
    Double servProcesamiento;
    Double igvServProcesamiento;
    Double servProcesamientoDolares;
    Double igvServProcesamientoDolares;
    String horaTransaccion;
    String banknetReference;
    Double intercambioLocal;
    Double igvIntercambioLocal;
    Double intercambioLocalDolares;
    Double igvIntercambioLocalDolares;
    String ird;
    Integer idMultiprod01;
    Double importeMultiprod01;
    Integer idMultiprod02;
	Double importeMultiprod02;
	Integer idMultiprod03;
	Double importeMultiprod03;
	Integer idMultiprod04;
	Double importeMultiprod04;
	Integer idMultiprod05;
	Double importeMultiprod05;
	String idMembresia;
	String idServicio;
	Integer idOrigen;
	Integer idClaseTransaccion;
	Integer idCodigoTransaccion;
	Integer idCanal;
	Integer idProducto;
	String idProceso;
	String transmissionTime;
	String traceNumber;
	String accountIdentification;
	String origenConciliacion;
	Integer secuenciaOrigenConciliacion;
	Integer indConciliacion;
	Date fechaConciliacion;
}
