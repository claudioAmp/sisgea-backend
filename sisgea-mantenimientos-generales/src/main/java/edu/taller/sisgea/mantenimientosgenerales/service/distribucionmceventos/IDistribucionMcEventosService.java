package edu.taller.sisgea.mantenimientosgenerales.service.distribucionmceventos;

import edu.taller.sisgea.mantenimientosgenerales.model.trasladoinstituciones.DistribucionMcEventos;

import java.util.List;

public interface IDistribucionMcEventosService {

    List<DistribucionMcEventos> buscarRegistrosDistribucionEventosMc();

    DistribucionMcEventos buscarRegistroDistribucionEventosMc(String secuenciaAgrupada);

    DistribucionMcEventos actualizarDistribucionMcEventos(String secuenciaAgrupada, DistribucionMcEventos distribucionMcEventos);

}
