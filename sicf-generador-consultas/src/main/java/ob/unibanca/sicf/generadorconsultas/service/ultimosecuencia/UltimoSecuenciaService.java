package ob.unibanca.sicf.generadorconsultas.service.ultimosecuencia;


import org.springframework.stereotype.Service;

import ob.unibanca.sicf.generadorconsultas.mapper.IUltimoSecuenciaMapper;
import ob.unibanca.sicf.generadorconsultas.model.UltimoSecuencia;


@Service
public class UltimoSecuenciaService  implements IUltimoSecuenciaService {
	
	private final IUltimoSecuenciaMapper ultimoSecuenciaMapper;
	public UltimoSecuenciaService(IUltimoSecuenciaMapper ultimoSecuenciaMapper ) {
		this.ultimoSecuenciaMapper =ultimoSecuenciaMapper ;
	}

	@Override
	public UltimoSecuencia obtenerUltimoSecuencia(String claseSecuencia) {
		UltimoSecuencia ultimoSecuencia = new UltimoSecuencia();
		ultimoSecuencia.setClaseSecuencia(claseSecuencia);
		ultimoSecuenciaMapper.obtenerUltimoSecuencia(ultimoSecuencia);
		return ultimoSecuencia;
	}

}

