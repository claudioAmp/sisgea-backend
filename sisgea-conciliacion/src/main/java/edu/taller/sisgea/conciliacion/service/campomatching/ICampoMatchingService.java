package edu.taller.sisgea.conciliacion.service.campomatching;

import edu.taller.sisgea.conciliacion.model.CampoMatching;
import ob.commons.mantenimiento.service.IMantenibleService;

import java.util.List;

public interface ICampoMatchingService extends IMantenibleService<CampoMatching> {

    List<CampoMatching> buscarTodosCamposMatching();

    CampoMatching buscarCampoMatching(Integer idCampoMatching, Integer idConcTabla);
    
    List<CampoMatching> buscarCampoMatchingPorConciliacionTablas(Integer idConcTabla);

    CampoMatching registrarCampoMatching(Integer idConcTabla, CampoMatching campoMatching);

    CampoMatching actualizarCampoMatching(Integer idCampoMatching, Integer idConcTabla,CampoMatching campoMatching);

    void eliminarCampoMatching(Integer idCampoMatching, Integer idConcTabla);

}
