package edu.taller.sisgea.mantenimientosgenerales.service.tasainterespasiva;

import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import edu.taller.sisgea.mantenimientosgenerales.mapper.ITasaInteresPasivaMapper;
import edu.taller.sisgea.mantenimientosgenerales.model.TasaInteresPasiva;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class TasaInteresPasivaService extends MantenibleService<TasaInteresPasiva> implements ITasaInteresPasivaService {
    private static final String TASA_NO_ENCONTRADA = "No existe una tasa de interes pasiva asignada a la fecha %s";
    private final ITasaInteresPasivaMapper tasaInteresPasivaMapper;

    public TasaInteresPasivaService(
            @Qualifier("ITasaInteresPasivaMapper") IMantenibleMapper<TasaInteresPasiva> mantenibleMapper) {
        super(mantenibleMapper);
        this.tasaInteresPasivaMapper = (ITasaInteresPasivaMapper) mantenibleMapper;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<TasaInteresPasiva> buscarTodasTasasInteresPasivas() {
        return this.tasaInteresPasivaMapper.buscarTodos();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public TasaInteresPasiva buscarTasaInteresPasiva(Date fechaProceso) {
        return this.tasaInteresPasivaMapper.buscarTasaInteresPasiva(fechaProceso).orElseThrow(
                () -> new RecursoNoEncontradoException(TASA_NO_ENCONTRADA, fechaProceso)
        );
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public TasaInteresPasiva registrarTasaInteresPasiva(TasaInteresPasiva tasaInteresPasiva) {
        System.out.println(tasaInteresPasiva);
        this.registrar(tasaInteresPasiva);
        return this.buscarTasaInteresPasiva(tasaInteresPasiva.getFechaProceso());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public TasaInteresPasiva actualizarTasaInteresPasiva(Date fechaProceso, TasaInteresPasiva tasaInteresPasiva) {
        this.actualizar(tasaInteresPasiva);
        return this.buscarTasaInteresPasiva(fechaProceso);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void eliminarTasaInteresPasiva(Date fechaProceso) {
        TasaInteresPasiva tasaInteresPasiva = TasaInteresPasiva.builder().fechaProceso(fechaProceso).build();
        this.eliminar(tasaInteresPasiva);
    }
}
