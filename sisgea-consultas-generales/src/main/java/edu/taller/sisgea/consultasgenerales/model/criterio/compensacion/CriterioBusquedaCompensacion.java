package edu.taller.sisgea.consultasgenerales.model.criterio.compensacion;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriterioBusquedaCompensacion {
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date fechaProcesoInicio;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date fechaProcesoFin;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date fechaTransaccionInicio;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date fechaTransaccionFin;
	String idSecuencia;
	String numeroTarjeta;
	List<Integer> monedasCompensacion;
	Double valorCompensacion;
	String numeroTrace;
	List<String> membresias;
	List<String> servicios;
	List<Integer> origenes;
	List<Integer> clasesTransaccion;
	List<Integer> codigosTransaccion;
	List<Integer> canales;
	List<Integer> instituciones;
	List<Integer> institucionesReceptoras;
	List<String> bines;
	List<String> codigosRespuesta;
	List<String> origenesArchivo;
	
	//filtros
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date filtroFechaProceso;
	private String filtroIdSecuencia;
	private String filtroIdMembresia;
	private String filtroIdServicio;
	private String filtroIdOrigen;
	private String filtroIdTransaccion;
	private String filtroIdCanal;
	private String filtroIdInstitucionEmisora;
	private String filtroIdInstitucionReceptora;
	private String filtroNumeroTarjeta;
	private String filtroBin;
	private String filtroIdMonedaCompensacion;
	private String filtroValorCompensacion;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date filtroFechaTransaccion;
	private String filtroHoraTransaccion;
	private String filtroCodigoRespuesta;
	private String filtroNumeroTrace;
	private String filtroCodigoAutorizacion;
	private String filtroReferenciaIntercambio;
	private String filtroGiroNegocio;
	private String filtroNombreAdquirente;
	private String filtroCiudadAdquirente;
	private String filtroPaisAdquirente;
	private String filtroIdOrigenArchivo;

	private String ordenFechaProceso;
	private String ordenIdSecuencia;
	private String ordenIdMembresia;
	private String ordenIdServicio;
	private String ordenIdOrigen;
	private String ordenIdTransaccion;
	private String ordenIdCanal;
	private String ordenIdInstitucionEmisora;
	private String ordenIdInstitucionReceptora;
	private String ordenNumeroTarjeta;
	private String ordenBin;
	private String ordenIdMonedaCompensacion;
	private String ordenValorCompensacion;
	private String ordenFechaTransaccion;
	private String ordenHoraTransaccion;
	private String ordenCodigoRespuesta;
	private String ordenNumeroTrace;
	private String ordenCodigoAutorizacion;
	private String ordenReferenciaIntercambio;
	private String ordenGiroNegocio;
	private String ordenNombreAdquirente;
	private String ordenPaisAdquirente;
	private String ordenIdOrigenArchivo;
	
	//Criterios de filtros de encabezado aggrid tipo RANGO
	private Double rangoValorCompensacionMin;
	private Double rangoValorCompensacionMax;
}
