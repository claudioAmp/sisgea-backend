package ob.unibanca.sicf.conciliacion.service.campodiferencia;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.conciliacion.model.CampoDiferencia;

import java.util.List;

public interface ICampoDiferenciaService extends IMantenibleService<CampoDiferencia> {

    List<CampoDiferencia> buscarTodosCampoDiferencias();

    CampoDiferencia buscarCampoDiferencia(Integer idCampoDiferencia, Integer idConcTabla);
    
    List<CampoDiferencia> buscarCampoDiferenciaPorConciliacionTablas(Integer idConcTabla);

    CampoDiferencia registrarCampoDiferencia(Integer idConcTabla, CampoDiferencia campoDiferencia);

    CampoDiferencia actualizarCampoDiferencia(Integer idCampoDiferencia, Integer idConcTabla,CampoDiferencia campoDiferencia);

    void eliminarCampoDiferencia(Integer idCampoDiferencia, Integer idConcTabla);

}
