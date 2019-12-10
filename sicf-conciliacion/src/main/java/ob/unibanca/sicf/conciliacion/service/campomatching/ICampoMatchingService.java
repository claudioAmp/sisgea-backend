package ob.unibanca.sicf.conciliacion.service.campomatching;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.conciliacion.model.CampoMatching;

import java.util.List;

public interface ICampoMatchingService extends IMantenibleService<CampoMatching> {

    List<CampoMatching> buscarTodosCamposMatching();

    CampoMatching buscarCampoMatching(Integer idCampoMatching, Integer idConcTabla);
    
    List<CampoMatching> buscarCampoMatchingPorConciliacionTablas(Integer idConcTabla);

    CampoMatching registrarCampoMatching(Integer idConcTabla, CampoMatching campoMatching);

    CampoMatching actualizarCampoMatching(Integer idCampoMatching, Integer idConcTabla,CampoMatching campoMatching);

    void eliminarCampoMatching(Integer idCampoMatching, Integer idConcTabla);

}
