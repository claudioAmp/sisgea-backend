package edu.taller.sisgea.mantenimientosgenerales.service.parametroconsulta;

import edu.taller.sisgea.mantenimientosgenerales.model.ParametroConsulta;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ParametroConsultaService extends MantenibleService<ParametroConsulta> implements IParametroConsultaService {
	
	public ParametroConsultaService(@Qualifier("IParametroConsultaMapper") IMantenibleMapper<ParametroConsulta> mantenibleMapper) {
		super(mantenibleMapper);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<ParametroConsulta> buscarTodosParametrosConsulta() {
		return this.buscarTodos();
	}
	
}
