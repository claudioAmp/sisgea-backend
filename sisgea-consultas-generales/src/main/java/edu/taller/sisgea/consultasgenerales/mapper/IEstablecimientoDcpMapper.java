package edu.taller.sisgea.consultasgenerales.mapper;

import com.github.pagehelper.Page;
import edu.taller.sisgea.consultasgenerales.model.criterio.establecimientodcp.CriterioBusquedaEstablecimientoDcp;
import edu.taller.sisgea.consultasgenerales.model.establecimientodcp.EstablecimientoDcp;
import edu.taller.sisgea.consultasgenerales.model.criterio.establecimientodcp.CriterioBusquedaEstablecimientoDcp;
import edu.taller.sisgea.consultasgenerales.model.establecimientodcp.EstablecimientoDcp;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IEstablecimientoDcpMapper {

    Page<EstablecimientoDcp> buscarPorCriterios(CriterioBusquedaEstablecimientoDcp criterioPaginacion);
}
