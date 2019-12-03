package ob.unibanca.sicf.mantenimientosgenerales.service.tasainterespasiva;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.TasaInteresPasiva;

import java.util.Date;
import java.util.List;

public interface ITasaInteresPasivaService extends IMantenibleService<TasaInteresPasiva> {
    List<TasaInteresPasiva> buscarTodasTasasInteresPasivas();
    TasaInteresPasiva buscarTasaInteresPasiva(Date fechaProceso);
    TasaInteresPasiva registrarTasaInteresPasiva(TasaInteresPasiva tasaInteresPasiva);
    TasaInteresPasiva actualizarTasaInteresPasiva(Date fechaProceso, TasaInteresPasiva tasaInteresPasiva);
    void eliminarTasaInteresPasiva(Date fechaProceso);
}