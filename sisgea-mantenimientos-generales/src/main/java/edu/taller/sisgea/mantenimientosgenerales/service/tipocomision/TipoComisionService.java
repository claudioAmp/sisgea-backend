package edu.taller.sisgea.mantenimientosgenerales.service.tipocomision;

import java.util.List;

import edu.taller.sisgea.mantenimientosgenerales.model.TipoComision;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;

@Service	
public class TipoComisionService extends MantenibleService<TipoComision> implements ITipoComisionService {
	
	public TipoComisionService(@Qualifier("ITipoComisionMapper") IMantenibleMapper<TipoComision> mantenibleMapper) {
		super(mantenibleMapper);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<TipoComision> buscarTodosTiposComision(){
		return this.buscarTodos();
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public TipoComision  buscarPorIdTipoComision(Integer idTipoComision){
		TipoComision tipoComision = TipoComision.builder().idTipoComision(idTipoComision).build(); 
		return this.buscarUno(tipoComision).get();
	}
}
