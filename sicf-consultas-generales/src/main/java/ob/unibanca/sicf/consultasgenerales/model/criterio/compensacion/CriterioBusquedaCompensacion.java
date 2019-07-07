package ob.unibanca.sicf.consultasgenerales.model.criterio.compensacion;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriterioBusquedaCompensacion {
	String fechaProcesoInicio;
	String fechaProcesoFin;
	Integer idSecuencia;
	String numeroTarjeta;
	List<Integer> monedasCompensacion;
	double valorCompensacion;
	String numeroTrace;
	List<String> membresias;
	List<String> servicios;
	List<Integer> origenes;
	List<Integer> clasesTransaccion;
	List<Integer> codigosTransaccion;
	List<Integer> roles;
	List<Integer> canales;
	List<Integer> instituciones;
	List<Integer> institucionesReceptoras;
	List<String> bines;
	List<String> codigosRespuesta;
	
	//filtros
	
	private String filtroFechaProceso;
	private String filtroIdSecuencia;
	private String filtroIdMembresia;
	private String filtroIdServicio;
	private String filtroIdOrigen;
	private String filtroIdClaseTransaccion;
	private String filtroIdCodigoTransaccion;
	private String filtroIdRol;
	private String filtroIdCanal;
	private String filtroIdInstitucionEmisora;
	private String filtroIdInstitucionReceptora;
	private String filtroNumeroTarjeta;
	private String filtroBin;
	private String filtroIdMonedaCompensacion;
	private String filtroValorCompensacion;
	private String filtroFechaSwitch;
	private String filtroHoraTransaccion;
	private String filtroCodigoRespuesta;
	private String filtroNumeroTrace;
	private String filtroCodigoAutorizacion;
	private String filtroReferenciaIntercambio;
	private String filtroGiroNegocio;
	private String filtroNombreAdquirente;
	private String filtroCiudadAdquirente;
	private String filtroPaisAdquirente;
	
	private String ordenFechaProceso;
	private String ordenIdSecuencia;
	private String ordenIdMembresia;
	private String ordenIdServicio;
	private String ordenIdOrigen;
	private String ordenIdClaseTransaccion;
	private String ordenIdCodigoTransaccion;
	private String ordenIdRol;
	private String ordenIdCanal;
	private String ordenIdInstitucionEmisora;
	private String ordenIdInstitucionReceptora;
	private String ordenNumeroTarjeta;
	private String ordenBin;
	private String ordenIdMonedaCompensacion;
	private String ordenValorCompensacion;
	private String ordenFechaSwitch;
	private String ordenHoraTransaccion;
	private String ordenCodigoRespuesta;
	private String ordenNumeroTrace;
	private String ordenCodigoAutorizacion;
	private String ordenReferenciaIntercambio;
	private String ordenGiroNegocio;
	private String ordenNombreAdquirente;
	private String ordenCiudadAdquirente;
	private String ordenPaisAdquirente;
}
