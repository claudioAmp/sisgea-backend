package edu.taller.sisgea.consultasgenerales.model.criterio.pmp;


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
public class CriterioBusquedaPMP {
	
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaProcesoInicio;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaProcesoFin;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaTransaccionInicio;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaTransaccionFin;
	private String idCodigoTransaccionPMP;
	private String idCodigoProductoPMP;
	private String numeroTarjeta;
	
	//filtros de cabecera de grilla
	private String filtroFechaProceso;
    private String filtroBinAdquirente;
    private String filtroNumeroTarjeta;
    private String filtroNombreEstablecimiento;
    private String filtroNombreCiudad;
    private String filtroIdCategoriaNegocio;
	private String filtroIdOrigenArchivo;
	private String filtroMedioTransaccion;
	private String filtroCodigoEstablecimiento;
    private String filtroCodigoAutorizacion;
    private String filtroIdPais;
    private String filtroTerminal;
    private String filtroUbicacionPos;
    private String filtroIcaEmisor;
    private String filtroTipoDevolucion;
    private String filtroCodigoAutorizacionDevolucion;
    private String filtroCodigoCuota;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date filtroFechaCuota;
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
	private String ordenFechaProceso;
	private String ordenBinAdquirente;
    private String ordenNumeroTarjeta;
    private String ordenNombreEstablecimiento;
    private String ordenNombreCiudad;
    private String ordenIdCategoriaNegocio;
	private String ordenIdOrigenArchivo;
	private String ordenMedioTransaccion;
	private String ordenCodigoEstablecimiento;
    private String ordenCodigoAutorizacion;
    private String ordenIdPais;
    private String ordenTerminal;
    private String ordenUbicacionPos;
    private String ordenIcaEmisor;
    private String ordenTipoDevolucion;
    private String ordenCodigoAutorizacionDevolucion;
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
