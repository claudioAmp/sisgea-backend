package ob.unibanca.sicf.conciliacion.service.campoinsertarobservada;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.conciliacion.model.CampoInsertarObservada;

import java.util.List;

public interface ICampoInsertarObservadaService extends IMantenibleService<CampoInsertarObservada> {

    List<CampoInsertarObservada> buscarTodosCampoInsertarObservadas();

    CampoInsertarObservada buscarCampoInsertarObservada(Integer idCmpInsObservada, Integer idConcTabla);
    
    List<CampoInsertarObservada> buscarCampoInsertarObservadaPorConciliacionTablas(Integer idConcTabla);

    CampoInsertarObservada registrarCampoInsertarObservada(Integer idConcTabla, CampoInsertarObservada campoInsertarObservada);

    CampoInsertarObservada actualizarCampoInsertarObservada(Integer idCmpInsObservada, Integer idConcTabla,CampoInsertarObservada campoInsertarObservada);

    void eliminarCampoInsertarObservada(Integer idCmpInsObservada, Integer idConcTabla);

}
