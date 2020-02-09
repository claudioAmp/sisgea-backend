package edu.taller.sisgea.consultasgenerales.controller.rest;

import com.github.pagehelper.Page;
import edu.taller.sisgea.consultasgenerales.service.establecimientodcp.IEstablecimientoDcpService;
import edu.taller.sisgea.consultasgenerales.model.criterio.establecimientodcp.CriterioBusquedaEstablecimientoDcp;
import edu.taller.sisgea.consultasgenerales.model.criterio.paginacion.Pagina;
import edu.taller.sisgea.consultasgenerales.model.establecimientodcp.EstablecimientoDcp;
import edu.taller.sisgea.consultasgenerales.service.establecimientodcp.IEstablecimientoDcpService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EstablecimientoDcpRestController {

    private final IEstablecimientoDcpService establecimientoDcpService;

    public EstablecimientoDcpRestController(IEstablecimientoDcpService establecimientoDcpService) {
        this.establecimientoDcpService = establecimientoDcpService;
    }

    @PreAuthorize("hasPermission('CON_ESTABLECIMIENTO_DCP', '2')")
    @GetMapping(value = "/establecimientosDcp/pagination")
    public Pagina<CriterioBusquedaEstablecimientoDcp, EstablecimientoDcp> buscarPorPaginas(
            Pagina<CriterioBusquedaEstablecimientoDcp, EstablecimientoDcp> criterioPaginacion,
            CriterioBusquedaEstablecimientoDcp criterioBusqueda) {
        criterioPaginacion.setCriterioBusqueda(criterioBusqueda);
        Page<EstablecimientoDcp> lista = this.establecimientoDcpService.buscarPorCriterios(
                criterioPaginacion.getCriterioBusqueda(),criterioPaginacion.getPageNum(),
                criterioPaginacion.getPageSize());
        return new Pagina<>(criterioPaginacion.getCriterioBusqueda(), lista);
    }
}
