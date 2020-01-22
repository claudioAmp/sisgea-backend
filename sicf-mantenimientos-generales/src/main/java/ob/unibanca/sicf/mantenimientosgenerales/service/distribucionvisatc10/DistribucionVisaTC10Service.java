package ob.unibanca.sicf.mantenimientosgenerales.service.distribucionvisatc10;

import ob.commons.error.exception.RecursoNoEncontradoException;
import ob.unibanca.sicf.mantenimientosgenerales.mapper.IDistribucionVisaTC10Mapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.trasladoinstituciones.DistribucionVisaTC10;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DistribucionVisaTC10Service implements IDistribucionVisaTC10Service {

    private final IDistribucionVisaTC10Mapper distribucionMapper;
    private static final String RECURSO_NO_ENCONTRADO = "El registro con secuencia %s";

    public DistribucionVisaTC10Service(@Qualifier("IDistribucionVisaTC10Mapper") IDistribucionVisaTC10Mapper mantenibleMapper) {
        this.distribucionMapper = (IDistribucionVisaTC10Mapper) mantenibleMapper;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<DistribucionVisaTC10> buscarRegistrosDistribucionVisaTC10() {
        return this.distribucionMapper.buscarRegistrosDistribucionVisaTC10();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public DistribucionVisaTC10 buscarRegistroDistribucionVisaTC10(String secuenciaAgrupada) {
        return this.distribucionMapper.buscarRegistroDistribucionVisaTC10(secuenciaAgrupada).orElseThrow(
                () -> new RecursoNoEncontradoException(RECURSO_NO_ENCONTRADO, secuenciaAgrupada));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public void eliminarDistribucionVisaTC10(String secuenciaAgrupada) {
        this.distribucionMapper.eliminarDistribucionVisaTC10(secuenciaAgrupada);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public DistribucionVisaTC10 actualizarDistribucionVisaTC10(String secuenciaAgrupada, DistribucionVisaTC10 DistribucionVisaTC10) {
        eliminarDistribucionVisaTC10(secuenciaAgrupada);
        DistribucionVisaTC10.getListaDistribucion().forEach(
                e->{
                    e.setSecuenciaAgrupada(secuenciaAgrupada);
                    //e.setFechaProceso(DistribucionVisaTC10.getFechaProceso());
                    this.distribucionMapper.registrarDistribucionVisaTC10(e);
                }
        );
        return this.buscarRegistroDistribucionVisaTC10(secuenciaAgrupada);
    }
}
