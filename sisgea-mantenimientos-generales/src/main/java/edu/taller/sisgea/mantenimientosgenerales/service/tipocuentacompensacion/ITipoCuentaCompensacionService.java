package edu.taller.sisgea.mantenimientosgenerales.service.tipocuentacompensacion;

import java.util.List;

import ob.commons.mantenimiento.service.IMantenibleService;
import edu.taller.sisgea.mantenimientosgenerales.model.TipoCuentaCompensacion;

public interface ITipoCuentaCompensacionService extends IMantenibleService <TipoCuentaCompensacion> {

	List<TipoCuentaCompensacion> buscarTodosTiposCuentaCompensacion();
}
