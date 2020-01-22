package ob.unibanca.sicf.mantenimientosgenerales.service.distribucionmceventos;

import ob.unibanca.sicf.mantenimientosgenerales.model.trasladoinstituciones.DistribucionMcEventos;

import java.util.List;

public interface IDistribucionMcEventosService {

    List<DistribucionMcEventos> buscarRegistrosDistribucionEventosMc();

    DistribucionMcEventos buscarRegistroDistribucionEventosMc(String secuenciaAgrupada);

    DistribucionMcEventos actualizarDistribucionMcEventos(String secuenciaAgrupada, DistribucionMcEventos distribucionMcEventos);

}
