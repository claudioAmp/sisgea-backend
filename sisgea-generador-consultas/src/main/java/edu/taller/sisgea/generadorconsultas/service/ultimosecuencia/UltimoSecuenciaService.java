package edu.taller.sisgea.generadorconsultas.service.ultimosecuencia;


import edu.taller.sisgea.generadorconsultas.model.UltimoSecuencia;
import org.springframework.stereotype.Service;

import edu.taller.sisgea.generadorconsultas.mapper.IUltimoSecuenciaMapper;


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

