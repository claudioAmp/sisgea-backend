package ob.unibanca.sicf.mantenimientosgenerales.service.codigoprocesoswitch;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.commons.validation.exception.RecursoNoEncontradoException;
import ob.unibanca.sicf.mantenimientosgenerales.mapper.ICodigoProcesoSwitchMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.CodigoProcesoSwitch;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CodigoProcesoSwitchService extends MantenibleService<CodigoProcesoSwitch> implements ICodigoProcesoSwitchService {

    private static final String CODIGO_PROCESO_SWITCH_NO_ENCONTRADO = "El Codigo Proceso Switch %s no fue encontrado";

    private final ICodigoProcesoSwitchMapper codigoProcesoSwitchMapper;

    public CodigoProcesoSwitchService(
            @Qualifier("ICodigoProcesoSwitchMapper") IMantenibleMapper<CodigoProcesoSwitch> mantenibleMapper){
        super(mantenibleMapper);
        this.codigoProcesoSwitchMapper = (ICodigoProcesoSwitchMapper) mantenibleMapper;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<CodigoProcesoSwitch> buscarTodosCodigoProcesoSwitches() { return super.buscarTodos(); }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public CodigoProcesoSwitch buscarCodigoProcesoSwitch(String idCodigoProcesoSwitch) {
        return this.codigoProcesoSwitchMapper.buscarUno(idCodigoProcesoSwitch).orElseThrow(
                () -> new RecursoNoEncontradoException(CODIGO_PROCESO_SWITCH_NO_ENCONTRADO, idCodigoProcesoSwitch));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public CodigoProcesoSwitch registrarCodigoProcesoSwitch(CodigoProcesoSwitch codigoProcesoSwitch) {
        super.registrar(codigoProcesoSwitch);
        return this.buscarCodigoProcesoSwitch(codigoProcesoSwitch.getIdCodigoProcesoSwitch());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public CodigoProcesoSwitch actualizarCodigoProcesoSwitch(
            String idCodigoProcesoSwitch, CodigoProcesoSwitch codigoProcesoSwitch) {
        codigoProcesoSwitch.setIdCodigoProcesoSwitch(idCodigoProcesoSwitch);
        super.actualizar(codigoProcesoSwitch);
        return this.buscarCodigoProcesoSwitch(codigoProcesoSwitch.getIdCodigoProcesoSwitch());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void eliminarCodigoProcesoSwitch(String idCodigoProcesoSwitch) {
        CodigoProcesoSwitch codigoProcesoSwitch =
                CodigoProcesoSwitch.builder().idCodigoProcesoSwitch(idCodigoProcesoSwitch).build();
        super.eliminar(codigoProcesoSwitch);
    }
}
