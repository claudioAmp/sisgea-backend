package edu.taller.sisgea.conciliacion.service.campodiferencia;

import edu.taller.sisgea.conciliacion.model.CampoDiferencia;
import ob.commons.mantenimiento.service.IMantenibleService;

import java.util.List;

public interface ICampoDiferenciaService extends IMantenibleService<CampoDiferencia> {

    List<CampoDiferencia> buscarTodosCampoDiferencias();

    CampoDiferencia buscarCampoDiferencia(Integer idCampoDiferencia, Integer idConcTabla);
    
    List<CampoDiferencia> buscarCampoDiferenciaPorConciliacionTablas(Integer idConcTabla);

    CampoDiferencia registrarCampoDiferencia(Integer idConcTabla, CampoDiferencia campoDiferencia);

    CampoDiferencia actualizarCampoDiferencia(Integer idCampoDiferencia, Integer idConcTabla,CampoDiferencia campoDiferencia);

    void eliminarCampoDiferencia(Integer idCampoDiferencia, Integer idConcTabla);

}
