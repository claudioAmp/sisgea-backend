package ob.unibanca.sicf.mantenimientosgenerales.service.distribucionvisaeventos;

import ob.unibanca.sicf.mantenimientosgenerales.mapper.IDistribucionVisaEventosMapper;
import ob.unibanca.sicf.mantenimientosgenerales.model.trasladoinstituciones.DistribucionVisaEventos;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ob.commons.error.exception.RecursoNoEncontradoException;

import java.util.List;

@Service
public class DistribucionVisaEventosService implements IDistribucionVisaEventosService {
	
	private final IDistribucionVisaEventosMapper distribucionMapper;
	private static final String RECURSO_NO_ENCONTRADO = "El registro con secuencia %s";
	
	public DistribucionVisaEventosService(@Qualifier("IDistribucionVisaEventosMapper") IDistribucionVisaEventosMapper mantenibleMapper) {
		this.distribucionMapper = (IDistribucionVisaEventosMapper) mantenibleMapper;
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<DistribucionVisaEventos> buscarRegistrosDistribucionEventosVisa() {
		return this.distribucionMapper.buscarRegistrosDistribucionEventosVisa();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public DistribucionVisaEventos buscarRegistroDistribucionEventosVisa(String secuenciaAgrupada) {
		return this.distribucionMapper.buscarRegistroDistribucionEventosVisa(secuenciaAgrupada).orElseThrow(
				() -> new RecursoNoEncontradoException(RECURSO_NO_ENCONTRADO, secuenciaAgrupada));
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public DistribucionVisaEventos actualizarDistribucionVisaEventos(String secuenciaAgrupada, DistribucionVisaEventos distribucionVisaEventos) {
		distribucionVisaEventos.setSecuenciaAgrupada(secuenciaAgrupada);
		distribucionVisaEventos.getListaDistribucion().forEach(
			e->{
				e.setSecuenciaAgrupada(secuenciaAgrupada);
				e.setIndUnits(distribucionVisaEventos.isIndUnits());
				this.distribucionMapper.actualizarDistribucionVisaEventos(e);
			}
		);
		return this.buscarRegistroDistribucionEventosVisa(secuenciaAgrupada);
	}
}
