package ob.unibanca.sicf.mantenimientosgenerales.service.tipocuentacompensacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import ob.unibanca.sicf.mantenimientosgenerales.model.TipoCuentaCompensacion;

@Service
public class TipoCuentaCompensacionService extends MantenibleService<TipoCuentaCompensacion> implements ITipoCuentaCompensacionService{

	public TipoCuentaCompensacionService(@Qualifier("ITipoCuentaCompensacionMapper") IMantenibleMapper<TipoCuentaCompensacion> mantenibleMapper) {
		super(mantenibleMapper);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<TipoCuentaCompensacion> buscarTodosTiposCuentaCompensacion(){
		return this.buscarTodos();
	}
}
