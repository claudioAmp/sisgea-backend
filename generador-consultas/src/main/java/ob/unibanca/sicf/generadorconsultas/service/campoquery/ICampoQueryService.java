package ob.unibanca.sicf.generadorconsultas.service.campoquery;

import java.util.List;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.generadorconsultas.model.CampoQuery;

public interface ICampoQueryService extends IMantenibleService<CampoQuery> {

    public List<CampoQuery> buscarTodosCampoQuery();

}