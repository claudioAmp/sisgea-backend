package edu.taller.sisgea.conciliacion.service.campoactualizar;

import edu.taller.sisgea.conciliacion.model.CampoActualizar;
import ob.commons.mantenimiento.service.IMantenibleService;

import java.util.List;

public interface ICampoActualizarService extends IMantenibleService<CampoActualizar> {

    List<CampoActualizar> buscarTodosCamposActualizar();

    CampoActualizar buscarCampoActualizar(Integer idCampoActualizar, Integer idConcTabla);
    
    List<CampoActualizar> buscarCampoActualizarPorConciliacionTablas(Integer idConcTabla);

    CampoActualizar registrarCampoActualizar(Integer idConcTabla, CampoActualizar campoActualizar);

    CampoActualizar actualizarCampoActualizar(Integer idCampoActualizar, Integer idConcTabla,CampoActualizar campoActualizar);

    void eliminarCampoActualizar(Integer idCampoActualizar, Integer idConcTabla);

}
