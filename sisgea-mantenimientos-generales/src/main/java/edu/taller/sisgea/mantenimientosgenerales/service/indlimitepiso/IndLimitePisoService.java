package edu.taller.sisgea.mantenimientosgenerales.service.indlimitepiso;

import java.util.List;

import edu.taller.sisgea.mantenimientosgenerales.mapper.IIndLimitePisoMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import edu.taller.sisgea.mantenimientosgenerales.model.IndLimitePiso;


@Service
public class IndLimitePisoService  extends MantenibleService<IndLimitePiso> implements IIndLimitePisoService {
	private final IIndLimitePisoMapper indLimitePisoMapper;
	
	public IndLimitePisoService(@Qualifier("IIndLimitePisoMapper") IMantenibleMapper<IndLimitePiso> mantenibleMapper) {
		super(mantenibleMapper);
		this.indLimitePisoMapper = (IIndLimitePisoMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<IndLimitePiso> buscarTodosIndLimitePiso() {
		
		return this.buscarTodos();
	}
		
}
