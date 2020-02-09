package edu.taller.sisgea.mantenimientosgenerales.service.categorianegocio;

import java.util.List;

import edu.taller.sisgea.mantenimientosgenerales.mapper.ICategoriaNegocioMapper;
import edu.taller.sisgea.mantenimientosgenerales.model.CategoriaNegocio;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;


@Service
public class CategoriaNegocioService  extends MantenibleService<CategoriaNegocio> implements ICategoriaNegocioService{
	
	private final ICategoriaNegocioMapper categoriaNegocioMapper;
	
	public CategoriaNegocioService(@Qualifier("ICategoriaNegocioMapper") IMantenibleMapper<CategoriaNegocio> mantenibleMapper) {
		super(mantenibleMapper);
		this.categoriaNegocioMapper = (ICategoriaNegocioMapper) mantenibleMapper;
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<CategoriaNegocio> buscarTodosCategoriasNegocios() {
		return this.buscarTodos();
	}
}
