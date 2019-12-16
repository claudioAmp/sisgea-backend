package ob.unibanca.sicf.consultasgenerales.model.pmp;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PMP {
	//Campos filtros de consulta
	String idMovIncomingPMP;
	String idCodigoTransaccionPMP;
	String descripcionCodigoTransaccionPMP;
    String idProductoPMP;
    Date fechaIncoming;
    String binAdquirente;
    Integer idTrace;
    String numeroTarjeta;
    String nombreEstablecimiento;
    String nombreCiudad;
    String idCategoriaNegocio;
    Date fechaProceso;
    ////////////////////
    String idOrigenArchivo;
    String origen;
    Integer idMoneda;
    String descripcionMoneda;
    Double tipoCambio;
    String medioTransaccion;
    Date fechaTransaccion;
    String codigoEstablecimiento;
    String codigoAutorizacion;
    Double valorTransaccion;
    Double valorComision;
    String idPais;
    Integer idBancoReceptor;
    Integer idAgenciaPagador;
    String terminal;
    Integer lote;
    Integer loteReferencia;
    String ubicacionPos;
    String icaEmisor;
    Double valorComisionEmisor;
    Double valorTransaccionDolares;
    Double valorComisionDolares;
    Double valorComisionEmisorDolares;
    String tipoDevolucion;
    String codigoAutorizacionDevolucion;
    Double pctComisionEstablecimiento;
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
	Integer idInstitucionEmisora;
	Integer idInstitucionReceptora;
	String idBin;
	String codigoUso;
	String binReceptor;
	String idProceso;
	String transmissionTime;
	String traceNumber;
	String accountIdentification;
	String origenConciliacion;
	Integer secuenciaOrigenConciliacion;
	Integer indConciliacion;
	Date fechaConciliacion;
}
