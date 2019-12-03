package ob.unibanca.sicf.conciliacion.service.campoactualizar;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.conciliacion.model.CampoActualizar;

import java.util.List;

public interface ICampoActualizarService extends IMantenibleService<CampoActualizar> {

    List<CampoActualizar> buscarTodosCamposActualizar();

    CampoActualizar buscarCampoActualizar(Integer idCampoActualizar, Integer idConcTabla);
    
    List<CampoActualizar> buscarCampoActualizarPorConciliacionTablas(Integer idConcTabla);

    CampoActualizar registrarCampoActualizar(Integer idConcTabla, CampoActualizar campoActualizar);

    CampoActualizar actualizarCampoActualizar(Integer idCampoActualizar, Integer idConcTabla,CampoActualizar campoActualizar);

    void eliminarCampoActualizar(Integer idCampoActualizar, Integer idConcTabla);

}
