package edu.taller.sisgea.consultasgenerales.service.establecimientodcp;

import com.github.pagehelper.Page;
import edu.taller.sisgea.consultasgenerales.model.criterio.establecimientodcp.CriterioBusquedaEstablecimientoDcp;
import edu.taller.sisgea.consultasgenerales.model.establecimientodcp.EstablecimientoDcp;

public interface IEstablecimientoDcpService {

    public Page<EstablecimientoDcp> buscarPorCriterios(CriterioBusquedaEstablecimientoDcp criterioPaginacion, int pageNo, int pageSize);
}
