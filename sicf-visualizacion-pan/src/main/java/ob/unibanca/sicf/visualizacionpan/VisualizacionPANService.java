package ob.unibanca.sicf.visualizacionpan;

import ob.commons.autorizacionjwt.util.UsuarioUtil;
import ob.commons.truncadorpan.decisor.IVisualizacionPANService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class VisualizacionPANService implements IVisualizacionPANService {
	
	private static final Logger logger = LoggerFactory.getLogger(VisualizacionPANService.class);
	private final IVisualizacionPANMapper visualizacionPANMapper;
	
	public VisualizacionPANService(IVisualizacionPANMapper visualizacionPANMapper) {
		this.visualizacionPANMapper = visualizacionPANMapper;
	}
	
	@Override
	public Boolean puedeVisualizarPAN() {
		String username = UsuarioUtil.obtenerUsername();
		String codigoAudiencia = UsuarioUtil.obtenerCodigoAudiencia();
		logger.info("Verificando si el usuario {} puede visualizar el PAN en el sistema {}", username,
				codigoAudiencia);
		return this.visualizacionPANMapper.puedeVisualizarPAN(username, codigoAudiencia);
	}
}
