package edu.taller.sisgea.mantenimientosgenerales.service.tasainterespasiva;

import edu.taller.sisgea.mantenimientosgenerales.model.TasaInteresPasiva;
import ob.commons.mantenimiento.service.IMantenibleService;

import java.util.Date;
import java.util.List;

public interface ITasaInteresPasivaService extends IMantenibleService<TasaInteresPasiva> {
    List<TasaInteresPasiva> buscarTodasTasasInteresPasivas();
    TasaInteresPasiva buscarTasaInteresPasiva(Date fechaProceso);
    TasaInteresPasiva registrarTasaInteresPasiva(TasaInteresPasiva tasaInteresPasiva);
    TasaInteresPasiva actualizarTasaInteresPasiva(Date fechaProceso, TasaInteresPasiva tasaInteresPasiva);
    void eliminarTasaInteresPasiva(Date fechaProceso);
}
