package ob.unibanca.sicf.mantenimientosgenerales.service.codigoprocesoswitch;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.CodigoProcesoSwitch;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

@Service
public class CodigoProcesoSwitchService extends MantenibleService<CodigoProcesoSwitch> implements ICodigoProcesoSwitchService {

    public CodigoProcesoSwitchService(
            @Qualifier("ICodigoProcesoSwitchMapper") IMantenibleMapper<CodigoProcesoSwitch> mantenibleMapper){
        super(mantenibleMapper);
    }

    @Override
    public List<CodigoProcesoSwitch> buscarTodosCodigoProcesoSwitches() { return super.buscarTodos(); }

    @Override
    public CodigoProcesoSwitch registrarCodigoProcesoSwitch(CodigoProcesoSwitch codigoProcesoSwitch) {
        super.registrar(codigoProcesoSwitch);
        return codigoProcesoSwitch;
    }

    @Override
    public CodigoProcesoSwitch actualizarCodigoProcesoSwitch(
            String idCodigoProcesoSwitch, CodigoProcesoSwitch codigoProcesoSwitch) {
        codigoProcesoSwitch.setIdCodigoProcesoSwitch(idCodigoProcesoSwitch);
        super.actualizar(codigoProcesoSwitch);
        return codigoProcesoSwitch;
    }

    @Override
    public void eliminarCodigoProcesoSwitch(String idCodigoProcesoSwitch) {
        CodigoProcesoSwitch codigoProcesoSwitch =
                CodigoProcesoSwitch.builder().idCodigoProcesoSwitch(idCodigoProcesoSwitch).build();
        super.eliminar(codigoProcesoSwitch);
    }
}
