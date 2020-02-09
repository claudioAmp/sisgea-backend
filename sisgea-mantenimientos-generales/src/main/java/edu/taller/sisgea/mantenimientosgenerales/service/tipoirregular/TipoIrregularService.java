package edu.taller.sisgea.mantenimientosgenerales.service.tipoirregular;

import java.util.List;

import edu.taller.sisgea.mantenimientosgenerales.mapper.ITipoIrregularMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import edu.taller.sisgea.mantenimientosgenerales.model.TipoIrregular;
@Service
public class TipoIrregularService extends MantenibleService<TipoIrregular> implements ITipoIrregularService {

	private final ITipoIrregularMapper tipoIrregularMapper;
	
	public TipoIrregularService(@Qualifier("ITipoIrregularMapper") IMantenibleMapper<TipoIrregular> mantenibleMapper) {
		super(mantenibleMapper);
		this.tipoIrregularMapper = (ITipoIrregularMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<TipoIrregular> buscarTodosTiposIrregular(){
		
		return this.buscarTodos();
	}

	
}
