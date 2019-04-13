package ob.unibanca.sicf.mantenimientosgenerales.service.tipocuentacompensacion;

import java.util.List;

import ob.commons.mantenimiento.service.IMantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.TipoCuentaCompensacion;

public interface ITipoCuentaCompensacionService extends IMantenibleService <TipoCuentaCompensacion> {

	List<TipoCuentaCompensacion> buscarTodosTiposCuentaCompensacion();
}
