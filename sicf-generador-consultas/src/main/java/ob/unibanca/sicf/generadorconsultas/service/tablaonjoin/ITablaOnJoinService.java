package ob.unibanca.sicf.generadorconsultas.service.tablaonjoin;

import java.util.List;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.generadorconsultas.model.TablaOnJoin;
import ob.unibanca.sicf.generadorconsultas.model.criterio.CriterioBusquedaTablaOnJoin;

public interface ITablaOnJoinService extends IMantenibleService<TablaOnJoin> {

    public List<TablaOnJoin> buscarTodosTablaOnJoin();
    
    List<TablaOnJoin> buscarPorCriteriosTablaOnJoin(CriterioBusquedaTablaOnJoin criterio);
	
	TablaOnJoin registrarTablaOnJoin(TablaOnJoin tablaOnJoin);
	
	TablaOnJoin actualizarTablaOnJoin(int idTablaOnJoinCampo, TablaOnJoin tablaOnJoin);
	
	void eliminarTablaOnJoin(int idTablaOnJoinCampo);

}