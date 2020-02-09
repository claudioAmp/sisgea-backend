package edu.taller.sisgea.mantenimientosgenerales.service.gironegocio;

import java.util.List;

import edu.taller.sisgea.mantenimientosgenerales.mapper.IGiroNegocioMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ob.commons.mantenimiento.mapper.IMantenibleMapper;
import ob.commons.mantenimiento.service.MantenibleService;
import edu.taller.sisgea.mantenimientosgenerales.model.GiroNegocio;

@Service
public class GiroNegocioService extends MantenibleService<GiroNegocio> implements IGiroNegocioService {
	
	private static final String GIRO_NEGOCIO_NO_ENCONTRADO = "No existe asociación entre el giro de negocio %s y la membresía %s";
	private final IGiroNegocioMapper giroNegocioMapper;
	
	public GiroNegocioService(@Qualifier("IGiroNegocioMapper") IMantenibleMapper<GiroNegocio> mantenibleMapper) {
		super(mantenibleMapper);
		this.giroNegocioMapper = (IGiroNegocioMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<GiroNegocio> buscarTodosGiroNegocio() {
		return this.giroNegocioMapper.buscarTodosGiroNegocio();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<GiroNegocio> buscarGiroNegocioPorMembresia(String idMembresia) {
		return this.giroNegocioMapper.buscarGiroNegocioPorMembresia(idMembresia);
	}

}
