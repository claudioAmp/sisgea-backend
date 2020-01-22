package ob.unibanca.sicf.consultasgenerales.model.criterio.establecimientodcp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CriterioBusquedaEstablecimientoDcp {

    private String idEstablecimiento;
    private String direccion;
    private String ciudad;
    private String codigoPostal;
    private String grupo;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fechaProcesoInicio;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fechaProcesoFin;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fechaProceso;

    /* Filtros de cabeceras */
    private Date filtroFechaProceso;
    private String filtroIdEstablecimiento;
    private String filtroDireccion;
    private String filtroCiudad;
    private String filtroCodigoPostal;
    private String filtroGrupo;

    /* Orden de cabeceras */
    private Date ordenFechaProceso;
    private String ordenIdEstablecimiento;
    private String ordenDireccion;
    private String ordenCiudad;
    private String ordenCodigoPostal;
    private String ordenGrupo;
}
