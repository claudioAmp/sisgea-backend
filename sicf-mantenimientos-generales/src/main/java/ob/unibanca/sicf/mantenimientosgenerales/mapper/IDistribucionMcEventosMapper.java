package ob.unibanca.sicf.mantenimientosgenerales.mapper;

import ob.unibanca.sicf.mantenimientosgenerales.model.trasladoinstituciones.DistribucionMcEventos;
import ob.unibanca.sicf.mantenimientosgenerales.model.trasladoinstituciones.DistribucionMcEventosDetalle;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface IDistribucionMcEventosMapper {

    List<DistribucionMcEventos> buscarRegistrosDistribucionEventosMc();

    Optional<DistribucionMcEventos> buscarRegistroDistribucionEventosMc(String secuenciaAgrupada);

    void actualizarDistribucionMcEventos(DistribucionMcEventosDetalle distribucionMcEventos);
}
