package edu.taller.sisgea.consultasgenerales.service.solicitud;

import java.util.List;

import edu.taller.sisgea.consultasgenerales.model.solicitud.Solicitud;

public interface ISolicitudService {
	List<Solicitud> buscarTodosSolictud();
	
	Solicitud buscarEspacioAcademico(Integer idEspacioAcademico);
	
	Solicitud registrarEspacioAcademico(Integer idEspacioAcademico,Integer idSolicitante);
	
	Solicitud actualizarEspacioAcademico(Integer idSolicitud);
	
	void eliminarEspacioAcademico(Integer idSolicitud);
}
