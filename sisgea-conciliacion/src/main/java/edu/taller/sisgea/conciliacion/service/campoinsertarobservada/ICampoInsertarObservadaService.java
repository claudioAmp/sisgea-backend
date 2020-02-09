package edu.taller.sisgea.conciliacion.service.campoinsertarobservada;

import edu.taller.sisgea.conciliacion.model.CampoInsertarObservada;
import ob.commons.mantenimiento.service.IMantenibleService;

import java.util.List;

public interface ICampoInsertarObservadaService extends IMantenibleService<CampoInsertarObservada> {

    List<CampoInsertarObservada> buscarTodosCampoInsertarObservadas();

    CampoInsertarObservada buscarCampoInsertarObservada(Integer idCmpInsObservada, Integer idConcTabla);
    
    List<CampoInsertarObservada> buscarCampoInsertarObservadaPorConciliacionTablas(Integer idConcTabla);

    CampoInsertarObservada registrarCampoInsertarObservada(Integer idConcTabla, CampoInsertarObservada campoInsertarObservada);

    CampoInsertarObservada actualizarCampoInsertarObservada(Integer idCmpInsObservada, Integer idConcTabla,CampoInsertarObservada campoInsertarObservada);

    void eliminarCampoInsertarObservada(Integer idCmpInsObservada, Integer idConcTabla);

}
