package ob.unibanca.sicf.mantenimientosgenerales.service.distribucionmceventos;

import ob.unibanca.sicf.mantenimientosgenerales.mapper.IDistribucionMcEventosMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.trasladoinstituciones.DistribucionMcEventos;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ob.commons.error.exception.RecursoNoEncontradoException;

import java.util.List;

@Service
public class DistribucionMcEventosService implements IDistribucionMcEventosService {

    private final IDistribucionMcEventosMapper distribucionMapper;
    private static final String RECURSO_NO_ENCONTRADO = "El registro con secuencia %s";

    public DistribucionMcEventosService(@Qualifier("IDistribucionMcEventosMapper") IDistribucionMcEventosMapper mantenibleMapper) {
        this.distribucionMapper = (IDistribucionMcEventosMapper) mantenibleMapper;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<DistribucionMcEventos> buscarRegistrosDistribucionEventosMc() {
        return this.distribucionMapper.buscarRegistrosDistribucionEventosMc();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public DistribucionMcEventos buscarRegistroDistribucionEventosMc(String secuenciaAgrupada) {
        return this.distribucionMapper.buscarRegistroDistribucionEventosMc(secuenciaAgrupada).orElseThrow(
                () -> new RecursoNoEncontradoException(RECURSO_NO_ENCONTRADO, secuenciaAgrupada));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public DistribucionMcEventos actualizarDistribucionMcEventos(String secuenciaAgrupada, DistribucionMcEventos distribucionMcEventos) {
        distribucionMcEventos.setSecuenciaAgrupada(secuenciaAgrupada);
        distribucionMcEventos.getListaDistribucion().forEach(
                e->{
                    e.setSecuenciaAgrupada(secuenciaAgrupada);
                    e.setIndUnits(distribucionMcEventos.isIndUnits());
                    this.distribucionMapper.actualizarDistribucionMcEventos(e);
                }
        );
        return this.buscarRegistroDistribucionEventosMc(secuenciaAgrupada);
    }
}
