package ob.unibanca.sicf.consultasgenerales.model.criterio.establecimientovisanet;

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
public class CriterioBusquedaEstablecimientoVisanet {
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date fechaProcesoInicio;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date fechaProcesoFin;
	String ruc;
	List<Integer> idsGiro;
	String ubigeo;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date fechaProceso;
	String idEstablecimiento;
	String idAdquirente;
	
	//filtros
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date filtroFechaProceso;
	private String filtroIdAdquirente;
	private String filtroIdEstablecimiento;
	private String filtroRuc;
	private String filtroRazonSocial;
	private String filtroNombreComercial;
	private String filtroIdGiro;
	private String filtroDireccion;
	private String filtroUbigeo;
	private String filtroRecurrente;
	private String filtroTipoFacturacion;

	private String ordenFechaProceso;
	private String ordenIdAdquirente;
	private String ordenIdEstablecimiento;
	private String ordenRuc;
	private String ordenRazonSocial;
	private String ordenNombreComercial;
	private String ordenIdGiro;
	private String ordenDireccion;
	private String ordenUbigeo;
	private String ordenRecurrente;
	private String ordenTipoFacturacion;
	
}
