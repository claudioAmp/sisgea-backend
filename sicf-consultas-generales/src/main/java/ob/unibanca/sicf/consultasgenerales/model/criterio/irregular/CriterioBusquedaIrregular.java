package ob.unibanca.sicf.consultasgenerales.model.criterio.irregular;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CriterioBusquedaIrregular {
	//Criterios
	Date fechaProceso;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date fechaProcesoInicio;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	Date fechaProcesoFin;
	
	List<String> origenesArchivo;
	List<Integer> tiposIrregular;
	
	//Filtros
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date filtroFechaProceso;
	String filtroSecuencia;
	String filtroIdTipoIrregular;
	String filtroIdMembresia;
	String filtroIdOrigen;
	String filtroIdServicio;
	String filtroTransaccion;
	String filtroIdCanal;
	String filtroBin;
	String filtroIdInstitucionEmisora;
	String filtroIdInstitucionReceptora;
	String filtroDescripcionIrregular;
	String filtroDetalleIrregular;
	String filtroOrigenArchivo;
	
	
	// Orden
	String ordenFechaProceso;
	String ordenOrigenArchivo;
	String ordenDetalleIrregular;
	String ordenSecuencia;
	String ordenIdTipoIrregular;
	String ordenIdMembresia;
	String ordenIdOrigen;
	String ordenIdServicio;
	String ordenTransaccion;
	String ordenIdCanal;
	String ordenBin;
	String ordenIdInstitucionEmisora;
	String ordenIdInstitucionReceptora;
}
