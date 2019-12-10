package ob.unibanca.sicf.consultasgenerales.model.criterio.pmp;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriterioBusquedaPMP {
	
	
	
	//filtros de cabecera de grilla
    private String filtroBinAdquirente;
    private String filtroIdTrace;
    private String filtroNumeroTarjeta;
    private String filtroNombreEstablecimiento;
    private String filtroNombreCiudad;
    private String filtroIdCategoriaNegocio;
	private String filtroIdOrigenArchivo;
	private String filtroMedioTransaccion;
	private String filtroCodigoEstablecimiento;
    private String filtroCodigoAutorizacion;
    private String filtroIdPais;
    private String filtroIdBancoReceptor;
    private String filtroIdAgenciaPagador;
    private String filtroTerminal;
    private String filtroLote;
    private String filtroLoteReferencia;
    private String filtroUbicacionPos;
    private String filtroIcaEmisor;
    private String filtroTipoDevolucion;
    private String filtroCodigoAutorizacionDevolucion;
    private String filtroPctComisionEstablecimiento;
    private String filtroCodigoCuota;
    private String filtroFechaCuota;
    private String filtroValorCuota;
    private String filtroIdItem;
    private String filtroIdArn; 
    private String filtroTasaIntercambio;
    private String filtroHoraTransaccion;
    private String filtroBanknetReference;
    private String filtroIrd;
    private String filtroIdMembresia;
	private String filtroIdServicio;
	private String filtroIdProceso;
	private String filtroTransmissionTime;
	private String filtroTraceNumber;
	private String filtroAccountIdentification;
	private String filtroOrigenConciliacion;
	
	//Ordenamiento
    private String ordenBinAdquirente;
    private String ordenIdTrace;
    private String ordenNumeroTarjeta;
    private String ordenNombreEstablecimiento;
    private String ordenNombreCiudad;
    private String ordenIdCategoriaNegocio;
	private String ordenIdOrigenArchivo;
	private String ordenMedioTransaccion;
	private String ordenCodigoEstablecimiento;
    private String ordenCodigoAutorizacion;
    private String ordenIdPais;
    private String ordenIdBancoReceptor;
    private String ordenIdAgenciaPagador;
    private String ordenTerminal;
    private String ordenLote;
    private String ordenLoteReferencia;
    private String ordenUbicacionPos;
    private String ordenIcaEmisor;
    private String ordenTipoDevolucion;
    private String ordenCodigoAutorizacionDevolucion;
    private String ordenPctComisionEstablecimiento;
    private String ordenCodigoCuota;
    private String ordenFechaCuota;
    private String ordenValorCuota;
    private String ordenIdItem;
    private String ordenIdArn; 
    private String ordenTasaIntercambio;
    private String ordenHoraTransaccion;
    private String ordenBanknetReference;
    private String ordenIrd;
    private String ordenIdMembresia;
	private String ordenIdServicio;
	private String ordenIdProceso;
	private String ordenTransmissionTime;
	private String ordenTraceNumber;
	private String ordenAccountIdentification;
	private String ordenOrigenConciliacion;
}
